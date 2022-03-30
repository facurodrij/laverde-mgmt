package gg.jte.generated.ondemand.admin.cosecha;
public final class JtecrearGenerated {
	public static final String JTE_NAME = "admin/cosecha/crear.jte";
	public static final int[] JTE_LINE_INFO = {0,0,0,0,2,2,2,4,4,6,8,16,16,17,17,24,24,26,26,26,31,31,32,32,33,36,41,53,53,56,56,57,57,57,57,57,57,57,57,57,57,58,58,60,60,64,64,70,70,73,73,74,74,74,74,74,74,74,74,74,74,75,75,77,77,81,81,89,89,92,92,93,93,93,93,93,93,93,93,93,93,94,94,96,96,100,100,134,136,136,139,139,148,148,150,153,158,160,164,164};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, edu.unam.jte.paginas.ModeloCosecha modelo) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.tag.JteadminheadGenerated.render(jteOutput, jteHtmlInterceptor);
		jteOutput.writeContent("\n\n");
		gg.jte.generated.ondemand.tag.JteadminsidebarGenerated.render(jteOutput, jteHtmlInterceptor);
		jteOutput.writeContent("\n\n");
		jteOutput.writeContent("\n<div class=\"content-wrapper\">\n  ");
		jteOutput.writeContent("\n  <section class=\"content-header\">\n    <div class=\"container-fluid\">\n      <div class=\"row mb-2\">\n        <div class=\"col-sm-6\">\n          <h1>Cosechas</h1>\n        </div>\n      </div>\n      ");
		if (modelo.excepcion != null) {
			jteOutput.writeContent("\n        ");
			if (modelo.excepcion == "") {
				jteOutput.writeContent("\n          <div class=\"alert alert-success alert-dismissible fade show\" role=\"alert\">\n            La cosecha se ha registrado correctamente\n            <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\">\n              <span aria-hidden=\"true\">&times;</span>\n            </button>\n          </div>\n        ");
			} else {
				jteOutput.writeContent("\n          <div class=\"alert alert-danger alert-dismissible fade show\" role=\"alert\">\n            ");
				jteOutput.setContext("div", null);
				jteOutput.writeUserContent(modelo.excepcion);
				jteOutput.writeContent("\t\n            <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\">\n              <span aria-hidden=\"true\">&times;</span>\n            </button>\n          </div>\n        ");
			}
			jteOutput.writeContent("\n      ");
		}
		jteOutput.writeContent("\n    </div>");
		jteOutput.writeContent("\n  </section>\n\n  ");
		jteOutput.writeContent("\n  <section class=\"content\">\n    <div class=\"container-fluid\">\n      <div class=\"row\">\n        <div class=\"col-12\">\n          ");
		jteOutput.writeContent("\n          <div class=\"card\">\n            <div class=\"card-header\">\n              <h3 class=\"card-title\">Crear Cosecha</h3>\n            </div>\n            <form action=\"/admin/cosechas/nuevo\" method=\"post\" id=\"cosecha\">\n              <div class=\"card-body\">\n                <div class=\"form-group row\">\n                  <div class=\"col-6 input-group\">\n                    <div class=\"input-group-prepend\">\n                      <span class=\"input-group-text\">Empleados</span>\n                    </div>\n                    ");
		if (!modelo.empleados.isEmpty()) {
			jteOutput.writeContent("\n                    <select class=\"form-control\" id=\"empleado\" multiple required>\n                      <option value=\"\" hidden selected>Seleccione una opción</option>\n                      ");
			for (var empleado : modelo.empleados) {
				jteOutput.writeContent("\n                      <option");
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(empleado.getIdEmpleado())) {
					jteOutput.writeContent(" value=\"");
					jteOutput.setContext("option", "value");
					jteOutput.writeUserContent(empleado.getIdEmpleado());
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(">");
				jteOutput.setContext("option", null);
				jteOutput.writeUserContent(empleado.toString());
				jteOutput.writeContent("</option>\n                      ");
			}
			jteOutput.writeContent("\n                    </select>\n                    ");
		} else {
			jteOutput.writeContent("\n                    <select class=\"form-control\" id=\"empleado\" disabled>\n                      <option value=\"\" hidden selected>No hay empleados</option>\n                    </select>\n                    ");
		}
		jteOutput.writeContent("\n                  </div>\n                  <div class=\"col-6 input-group\">\n                    <div class=\"input-group-prepend\">\n                      <span class=\"input-group-text\">Cuadros</span>\n                    </div>\n                    ");
		if (!modelo.cuadros.isEmpty()) {
			jteOutput.writeContent("\n                      <select class=\"form-control\" id=\"cuadro\" multiple required>\n                        <option value=\"\" hidden selected>Seleccione una opción</option>\n                        ");
			for (var cuadro : modelo.cuadros) {
				jteOutput.writeContent("\n                          <option");
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(cuadro.getIdCuadro())) {
					jteOutput.writeContent(" value=\"");
					jteOutput.setContext("option", "value");
					jteOutput.writeUserContent(cuadro.getIdCuadro());
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(">");
				jteOutput.setContext("option", null);
				jteOutput.writeUserContent(cuadro.toString());
				jteOutput.writeContent("</option>\n                        ");
			}
			jteOutput.writeContent("\n                      </select>\n                    ");
		} else {
			jteOutput.writeContent("\n                      <select class=\"form-control\" id=\"cuadro\" disabled>\n                        <option value=\"\" hidden selected>No hay cuadros</option>\n                      </select>\n                    ");
		}
		jteOutput.writeContent("\n                  </div>\n                </div>\n                <div class=\"form-group row\">\n                  <div class=\"col-12 input-group\">\n                    <div class=\"input-group-prepend\">\n                      <span class=\"input-group-text\">Secaderos</span>\n                    </div>\n                    ");
		if (!modelo.secaderos.isEmpty()) {
			jteOutput.writeContent("\n                    <select class=\"form-control\" id=\"secadero\" required>\n                      <option value=\"\" hidden selected>Seleccione una opción</option>\n                      ");
			for (var secadero : modelo.secaderos) {
				jteOutput.writeContent("\n                      <option");
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(secadero.getIdSecadero())) {
					jteOutput.writeContent(" value=\"");
					jteOutput.setContext("option", "value");
					jteOutput.writeUserContent(secadero.getIdSecadero());
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(">");
				jteOutput.setContext("option", null);
				jteOutput.writeUserContent(secadero.toString());
				jteOutput.writeContent("</option>\n                      ");
			}
			jteOutput.writeContent("\n                    </select>\n                    ");
		} else {
			jteOutput.writeContent("\n                    <select class=\"form-control\" id=\"secadero\" disabled>\n                      <option value=\"\" hidden selected>No hay secaderos</option>\n                    </select>\n                    ");
		}
		jteOutput.writeContent("\n                  </div>\n                </div>\n                <div class=\"form-group row\">\n                  <div class=\"col-6 input-group\">\n                    <div class=\"input-group-prepend\">\n                      <span class=\"input-group-text\">Peso Entrega</span>\n                    </div>\n                    <input class=\"form-control\" type=\"number\" step=\"0.001\" placeholder=\"Ingrese el peso de entrega\" id=\"pesoEntrega\" required />\n                    <small></small>\n                  </div>\n                  <div class=\"col-6 input-group\">\n                    <div class=\"input-group-prepend\">\n                      <span class=\"input-group-text\">Fecha Entrega</span>\n                    </div>\n                    <input class=\"form-control\" type=\"date\" id=\"tiempoEntrega\" required />\n                  </div>\n                </div>\n                <div class=\"form-group row\">\n                  <div class=\"col-6 input-group\">\n                    <div class=\"input-group-prepend\">\n                      <span class=\"input-group-text\">Peso Registro</span>\n                    </div>\n                    <input class=\"form-control\" type=\"number\" step=\"0.001\" placeholder=\"Ingrese el peso de registro\" id=\"pesoRegistro\" required />\n                    <small></small>\n                  </div>\n                  <div class=\"col-6 input-group\">\n                    <div class=\"input-group-prepend\">\n                      <span class=\"input-group-text\">Fecha Registro</span>\n                    </div>\n                    <input class=\"form-control\" type=\"date\" id=\"tiempoRegistro\" required />\n                  </div>\n                </div>\n              </div>\n              ");
		jteOutput.writeContent("\n              <div class=\"card-footer\">\n                ");
		if (!(modelo.empleados.isEmpty() || modelo.cuadros.isEmpty() || modelo.secaderos.isEmpty())) {
			jteOutput.writeContent("\n                  <button type=\"submit\" class=\"btn btn-primary\"><i class=\"fas fa-save\"></i> Guardar</button>\n                  <a href=\".\" type=\"button\" class=\"btn btn-secondary\"> Volver </a>\n                ");
		} else {
			jteOutput.writeContent("\n                  <button disabled type=\"submit\" class=\"btn btn-primary\"><i class=\"fas fa-save\"></i> Guardar</button>\n                  <a href=\".\" type=\"button\" class=\"btn btn-secondary\"> Volver </a>\n                  <div class=\"alert mt-3 alert-danger alert-dismissible fade show\" role=\"alert\">\n                    Debe tener un Empleado, un Cuadro y un Secadero registrado.\t\n                    <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\">\n                      <span aria-hidden=\"true\">&times;</span>\n                    </button>\n                  </div>\n                ");
		}
		jteOutput.writeContent("\n              </div>\n              ");
		jteOutput.writeContent("\n            </form>\n          </div>\n          ");
		jteOutput.writeContent("\n        </div>\n      </div>\n    </div>\n  </section>\n  ");
		jteOutput.writeContent("\n</div>\n");
		jteOutput.writeContent("\n\n<script src=\"/js/cosecha/crear.js\"></script>\n\n");
		gg.jte.generated.ondemand.tag.JtefooterGenerated.render(jteOutput, jteHtmlInterceptor);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		edu.unam.jte.paginas.ModeloCosecha modelo = (edu.unam.jte.paginas.ModeloCosecha)params.get("modelo");
		render(jteOutput, jteHtmlInterceptor, modelo);
	}
}
