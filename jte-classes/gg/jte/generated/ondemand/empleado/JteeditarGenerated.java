package gg.jte.generated.ondemand.empleado;
public final class JteeditarGenerated {
	public static final String JTE_NAME = "empleado/editar.jte";
	public static final int[] JTE_LINE_INFO = {0,0,0,0,2,2,2,4,4,6,8,19,19,19,23,23,25,25,25,30,30,31,34,39,44,44,44,45,45,45,45,45,45,45,53,53,53,53,53,53,53,60,60,60,60,60,60,60,67,67,67,67,67,67,67,76,76,76,76,76,76,76,85,85,85,85,85,85,85,94,94,94,94,94,94,94,101,101,101,101,101,101,101,105,110,113,118,120,124,124};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, edu.unam.jte.paginas.ModeloEmpleado modelo) {
		jteOutput.writeContent("\r\n");
		gg.jte.generated.ondemand.tag.JteheadGenerated.render(jteOutput, jteHtmlInterceptor);
		jteOutput.writeContent("\r\n\r\n");
		gg.jte.generated.ondemand.tag.JtesidebarGenerated.render(jteOutput, jteHtmlInterceptor);
		jteOutput.writeContent("\r\n\r\n");
		jteOutput.writeContent("\r\n<div class=\"content-wrapper\">\r\n  ");
		jteOutput.writeContent("\r\n  <section class=\"content-header\">\r\n    <div class=\"container-fluid\">\r\n      <div class=\"row mb-2\">\r\n        <div class=\"col-sm-6\">\r\n          <h1>Empleados</h1>\r\n        </div>\r\n        <div class=\"col-sm-6\">\r\n          <ol class=\"breadcrumb float-sm-right\">\r\n            <li class=\"breadcrumb-item\"><a href=\"/\">Inicio</a></li>\r\n            <li class=\"breadcrumb-item\"><a href=\"/empleados\">Empleados</a></li>\r\n            <li class=\"breadcrumb-item active\">");
		jteOutput.setContext("li", null);
		jteOutput.writeUserContent(modelo.empleado.getNombres());
		jteOutput.writeContent("</li>\r\n          </ol>\r\n        </div>\r\n      </div>\r\n      ");
		if (modelo.exception != null) {
			jteOutput.writeContent("\r\n        <div class=\"alert alert-danger alert-dismissible fade show\" role=\"alert\">\r\n          ");
			jteOutput.setContext("div", null);
			jteOutput.writeUserContent(modelo.exception.getCause().getCause().getMessage());
			jteOutput.writeContent("\t\r\n          <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\">\r\n            <span aria-hidden=\"true\">&times;</span>\r\n          </button>\r\n        </div>\r\n      ");
		}
		jteOutput.writeContent("\r\n    </div>");
		jteOutput.writeContent("\r\n  </section>\r\n\r\n  ");
		jteOutput.writeContent("\r\n  <section class=\"content\">\r\n    <div class=\"container-fluid\">\r\n      <div class=\"row\">\r\n        <div class=\"col-12\">\r\n          ");
		jteOutput.writeContent("\r\n          <div class=\"card\">\r\n            <div class=\"card-header\">\r\n              <h3 class=\"card-title\">Editar Empleado</h3>\r\n            </div>\r\n            <form action=\"/empleados/");
		jteOutput.setContext("form", "action");
		jteOutput.writeUserContent(modelo.empleado.getIdEmpleado());
		jteOutput.writeContent("\" method=\"post\" id=\"empleado\">\r\n              <input class=\"form-control\" type=\"hidden\" id=\"idEmpleado\"");
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(modelo.empleado.getIdEmpleado())) {
			jteOutput.writeContent(" value=\"");
			jteOutput.setContext("input", "value");
			jteOutput.writeUserContent(modelo.empleado.getIdEmpleado());
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(" />\r\n              <div class=\"card-body\">\r\n                <div class=\"form-group row\">\r\n                  <div class=\"col-4 input-group\">\r\n                    <div class=\"input-group-prepend\">\r\n                      <span class=\"input-group-text\">Legajo</span>\r\n                    </div>\r\n                    <input class=\"form-control\" type=\"text\" placeholder=\"Ingrese el legajo\" id=\"legajo\"");
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(modelo.empleado.getLegajo())) {
			jteOutput.writeContent(" value=\"");
			jteOutput.setContext("input", "value");
			jteOutput.writeUserContent(modelo.empleado.getLegajo());
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(" required />\r\n                  </div>\r\n                  <div class=\"col-4 input-group\">\r\n                    <div class=\"input-group-prepend\">\r\n                      <span class=\"input-group-text\">CUIL</span>\r\n                    </div>\r\n                    <input class=\"form-control\" type=\"text\" placeholder=\"Ingrese el cuil\" id=\"cuil\"");
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(modelo.empleado.getCuil())) {
			jteOutput.writeContent(" value=\"");
			jteOutput.setContext("input", "value");
			jteOutput.writeUserContent(modelo.empleado.getCuil());
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(" required />\r\n                  </div>\r\n                  <div class=\"col-4 input-group\">\r\n                    <div class=\"input-group-prepend\">\r\n                      <span class=\"input-group-text\">DNI</span>\r\n                    </div>\r\n                    <input class=\"form-control\" type=\"text\" id=\"dni\"");
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(modelo.empleado.getDni())) {
			jteOutput.writeContent(" value=\"");
			jteOutput.setContext("input", "value");
			jteOutput.writeUserContent(modelo.empleado.getDni());
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(" required />\r\n                  </div>\r\n                </div>\r\n                <div class=\"form-group row\">\r\n                  <div class=\"col-12 input-group\">\r\n                    <div class=\"input-group-prepend\">\r\n                      <span class=\"input-group-text\">Nombre</span>\r\n                    </div>\r\n                    <input class=\"form-control\" type=\"text\" placeholder=\"Ingrese el nombre\" id=\"nombres\"");
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(modelo.empleado.getNombres())) {
			jteOutput.writeContent(" value=\"");
			jteOutput.setContext("input", "value");
			jteOutput.writeUserContent(modelo.empleado.getNombres());
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(" required />\r\n                  </div>\r\n                </div>\r\n                <div class=\"form-group row\">\r\n                  <div class=\"col-12 input-group\">\r\n                    <div class=\"input-group-prepend\">\r\n                      <span class=\"input-group-text\">Apellido</span>\r\n                    </div>\r\n                    <input class=\"form-control\" type=\"text\" placeholder=\"Ingrese el apellido\" id=\"apellidos\"");
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(modelo.empleado.getApellidos())) {
			jteOutput.writeContent(" value=\"");
			jteOutput.setContext("input", "value");
			jteOutput.writeUserContent(modelo.empleado.getApellidos());
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(" required />\r\n                  </div>\r\n                </div>\r\n                <div class=\"form-group row\">\r\n                  <div class=\"col-6 input-group\">\r\n                    <div class=\"input-group-prepend\">\r\n                      <span class=\"input-group-text\">Fecha Ingreso</span>\r\n                    </div>\r\n                    <input class=\"form-control\" type=\"date\" id=\"ingreso\"");
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(modelo.empleado.getIngreso().toString())) {
			jteOutput.writeContent(" value=\"");
			jteOutput.setContext("input", "value");
			jteOutput.writeUserContent(modelo.empleado.getIngreso().toString());
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(" required />\r\n                  </div>\r\n                  <div class=\"col-6 input-group\">\r\n                    <div class=\"input-group-prepend\">\r\n                      <span class=\"input-group-text\">Fecha Nacimiento</span>\r\n                    </div>\r\n                    <input class=\"form-control\" type=\"date\" id=\"nacimiento\"");
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(modelo.empleado.getNacimiento().toString())) {
			jteOutput.writeContent(" value=\"");
			jteOutput.setContext("input", "value");
			jteOutput.writeUserContent(modelo.empleado.getNacimiento().toString());
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(" required />\r\n                  </div>\r\n                </div>\r\n              </div>\r\n              ");
		jteOutput.writeContent("\r\n              <div class=\"card-footer\">\r\n                <button type=\"submit\" class=\"btn btn-primary\"><i class=\"fas fa-save\"></i> Guardar</button>\r\n                <a href=\".\" type=\"button\" class=\"btn btn-secondary\"> Volver </a>\r\n              </div>\r\n              ");
		jteOutput.writeContent("\r\n            </form>\r\n          </div>\r\n          ");
		jteOutput.writeContent("\r\n        </div>\r\n      </div>\r\n    </div>\r\n  </section>\r\n  ");
		jteOutput.writeContent("\r\n</div>\r\n");
		jteOutput.writeContent("\r\n\r\n<script src=\"/js/empleado/actualizar.js\"></script>\r\n\r\n");
		gg.jte.generated.ondemand.tag.JtefooterGenerated.render(jteOutput, jteHtmlInterceptor);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		edu.unam.jte.paginas.ModeloEmpleado modelo = (edu.unam.jte.paginas.ModeloEmpleado)params.get("modelo");
		render(jteOutput, jteHtmlInterceptor, modelo);
	}
}
