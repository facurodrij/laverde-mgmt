package edu.unam.jte.controladores;

import io.javalin.http.Context;

import java.time.LocalDate;
import java.util.Collections;

import edu.unam.jte.repositorios.Repositorio;
import edu.unam.jte.modelos.*;
import edu.unam.jte.paginas.*;

public class EmpleadosControlador {
    private Repositorio repositorio;

    private String excepcion = null;

    private int eliminado = 0;

    public EmpleadosControlador(Repositorio repositorio) {
        this.repositorio = repositorio;
    }

    private long digito(long numero, int digi) {
        long exacto = 1;
        for (int i = 1; i <= digi; i++) {
            exacto *= 10;
        }
        long masUno = exacto * 10;
        if (digi < 0) {
            return 0;
        }
        System.out.println(numero % masUno);
        System.out.println(numero % masUno / exacto);
        return numero / exacto % masUno;
    }

    private boolean cuilValido(long cuil) {
        if (cuil < 0) {
            return false;
        }
        switch ((int)(cuil / 1000000000)) {
            case 20: break;
            case 23: break;
            case 24: break;
            case 27: break;
            default: return false;
        }
        long original = 0;
        long codigo = 5432765432l;
        long suma = 0;
        if (cuil / 1000000000l == 23) {
            switch ((int)(cuil % 10)) {
                case 9: original = (cuil % 1000000000l) + 20000000000l; break;
                case 4: original = (cuil % 1000000000l) + 27000000000l; break;
                case 3: original = (cuil % 1000000000l) + 24000000000l;
            }
            for (int i = 0; i < 10; i++) {
                suma = suma + (digito(original, i+1) * digito(codigo, i));
            }
            if ((11 - (suma % 11)) == 1) {
                return true;
            }
            return false;
        }
        switch ((int)(cuil / 1000000000)) {
            case 20: if ((cuil % 11) == 9) {return false;} break;
            case 27: if ((cuil % 11) == 4) {return false;} break;
            case 24: if ((cuil % 11) == 3) {return false;}
        }
        for (int i = 0; i < 10; i++) {
            suma = suma + digito(cuil, i+1) * digito(codigo, i);
        }
        switch (11 - (int)(suma % 11)) {
            case 0: return false;
            case 11: suma = 0; break;
            case 10: suma = 1; break;
            default: suma = 11-(suma % 11);
        }
        if (suma != (cuil % 10)) {
            return false;
        }
        return true;
    }

    public void listar(Context ctx) {
        if (!(ctx.cookie("usuario").equals("admin"))) {
            ctx.cookie("usuario", "cualquiera");
            ctx.redirect("/");
            return;
        }
        var modelo = new ModeloEmpleados();
        modelo.eliminado = eliminado;
        modelo.excepcion = excepcion;
        eliminado = 0;
        excepcion = null;
        modelo.empleados = repositorio.buscarTodos(Empleado.class);
        for (int i = 0; i < modelo.empleados.size(); i++) {
            if (modelo.empleados.get(i).esInvalido()) {
                modelo.empleados.remove(i);
            }
        }
        ctx.render("admin/empleado/listar.jte", Collections.singletonMap("modelo", modelo));
    }

    public void nuevo(Context ctx) {
        if (!(ctx.cookie("usuario").equals("admin"))) {
            ctx.cookie("usuario", "cualquiera");
            ctx.redirect("/");
            return;
        }
        var modelo = new ModeloEmpleado();
        modelo.excepcion = excepcion;
        excepcion = null;
        ctx.render("admin/empleado/crear.jte", Collections.singletonMap("modelo", modelo));
    }

    public void crear(Context ctx) throws Exception {
        var cuil = Long.parseLong(ctx.formParam("cuil"));
        int dni = 0;
        if (cuilValido(cuil)) {
            dni = (int)(cuil % 1000000000 / 10);
        } else {
            excepcion = "El CUIL no es válido";
            throw new Exception(excepcion);
        }
        var legajo = ctx.formParam("legajo");
        var apellidos = ctx.formParam("apellidos");
        var nombres = ctx.formParam("nombres");
        var ingreso = LocalDate.parse(ctx.formParam("ingreso"));
        var nacimiento = LocalDate.parse(ctx.formParam("nacimiento"));
        Empleado empleado = new Empleado(legajo, dni, apellidos, nombres, ingreso, nacimiento, cuil);
        this.repositorio.iniciarTransaccion();
        try {
            this.repositorio.insertar(empleado);
            this.repositorio.confirmarTransaccion();
        } catch (Exception e) {
            this.repositorio.descartarTransaccion();
            e.printStackTrace();
            excepcion = e.getCause().getCause().getMessage();
            throw new Exception(excepcion);
        }
        excepcion = "";
    }

    public void modificar(Context ctx) {
        if (!(ctx.cookie("usuario").equals("admin"))) {
            ctx.cookie("usuario", "cualquiera");
            ctx.redirect("/");
            return;
        }
        var modelo = new ModeloEmpleado();
        modelo.empleado = this.repositorio.buscar(Empleado.class, Integer.parseInt(ctx.pathParam("id")));
        if (modelo.empleado != null) {
            if (modelo.empleado.esValido()) {
                modelo.excepcion = excepcion;
                excepcion = null;
                ctx.render("admin/empleado/editar.jte", Collections.singletonMap("modelo", modelo));
                return;
            }
            excepcion = "El empleado al que intentó acceder fue eliminado anteriormente";
        } else {
            excepcion = "El empleado al que intentó acceder no existe";
        }
        ctx.redirect("/empleados");
    }

    public void actualizar(Context ctx) throws Exception {
        var cuil = Long.parseLong(ctx.formParam("cuil"));
        int dni = 0;
        if (cuilValido(cuil)) {
            dni = (int)(cuil % 1000000000 / 10);
        } else {
            excepcion = "El CUIL no es válido";
            throw new Exception(excepcion);
        }
        var legajo = ctx.formParam("legajo");
        var apellidos = ctx.formParam("apellidos");
        var nombres = ctx.formParam("nombres");
        var ingreso = LocalDate.parse(ctx.formParam("ingreso"));
        var nacimiento = LocalDate.parse(ctx.formParam("nacimiento"));
        Empleado empleado = this.repositorio.buscar(Empleado.class,
            Integer.parseInt(ctx.pathParam("id")));
        if (empleado != null) {
            empleado.setLegajo(legajo);
            empleado.setDni(dni);
            empleado.setCuil(cuil);
            empleado.setApellidos(apellidos);
            empleado.setNombres(nombres);
            empleado.setIngreso(ingreso);
            empleado.setNacimiento(nacimiento);
            this.repositorio.iniciarTransaccion();
            try {
                this.repositorio.actualizar(empleado);
                this.repositorio.confirmarTransaccion();
            } catch (Exception e) {
                this.repositorio.descartarTransaccion();
                e.printStackTrace();
                excepcion = e.getCause().getCause().getMessage();
                throw new Exception(excepcion);
            }
            excepcion = "";
        } else {
            excepcion = "El empleado a modificar no se ha encontrado o lo han eliminado";
            throw new Exception(excepcion);
        }
    }

    public void borrar(Context ctx) throws Exception {
        Empleado empleado = this.repositorio.buscar(Empleado.class,
            Integer.parseInt(ctx.pathParam("id")));
        if (empleado != null) {
            var cosechas = repositorio.buscarTodos(Cosecha.class);
            for (int i = 0; i < cosechas.size(); i++) {
                if (cosechas.get(i).esValido()) {
                    for (var emple: cosechas.get(i).getEmpleados()) {
                        if (empleado == emple) {
                            excepcion = "Hay cosecha(s) que fueron realizada(s) por este empleado";
                            throw new Exception(excepcion);
                        }
                    }
                }
            }
            empleado.eliminar();
            this.repositorio.iniciarTransaccion();
            try {
                this.repositorio.actualizar(empleado);
                this.repositorio.confirmarTransaccion();
            } catch (Exception e) {
                this.repositorio.descartarTransaccion();
                e.printStackTrace();
                excepcion = e.getCause().getCause().getMessage();
                throw new Exception(excepcion);
            }
            eliminado = empleado.getIdEmpleado();
            excepcion = "";
        } else {
            excepcion = "El empleado a eliminar no se encuentra en el sistema";
            throw new Exception(excepcion);
        }
    }

    public void recuperar(Context ctx) throws Exception {
        Empleado empleado = this.repositorio.buscar(Empleado.class,
            Integer.parseInt(ctx.formParam("id")));
        if (empleado != null) {
            empleado.recuperar();
            this.repositorio.iniciarTransaccion();
            try {
                this.repositorio.actualizar(empleado);
                this.repositorio.confirmarTransaccion();
            } catch (Exception e) {
                this.repositorio.descartarTransaccion();
                e.printStackTrace();
                excepcion = e.getCause().getCause().getMessage();
                throw new Exception(excepcion);
            }
            eliminado = empleado.getIdEmpleado();
            excepcion = null;
        } else {
            excepcion = "No se puede recuperar el empleado deseado";
            throw new Exception(excepcion);
        }
    }
}
