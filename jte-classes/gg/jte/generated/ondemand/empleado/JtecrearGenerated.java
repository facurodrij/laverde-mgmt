package gg.jte.generated.ondemand.empleado;
public final class JtecrearGenerated {
	public static final String JTE_NAME = "empleado/crear.jte";
	public static final int[] JTE_LINE_INFO = {0,0,0,0,2,2,2,4,4,6,8,23,23,25,25,25,30,30,31,34,39,97,102,105,110,112,116,116};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, edu.unam.jte.paginas.ModeloEmpleado modelo) {
		jteOutput.writeContent("\r\n");
		gg.jte.generated.ondemand.tag.JteheadGenerated.render(jteOutput, jteHtmlInterceptor);
		jteOutput.writeContent("\r\n\r\n");
		gg.jte.generated.ondemand.tag.JtesidebarGenerated.render(jteOutput, jteHtmlInterceptor);
		jteOutput.writeContent("\r\n\r\n");
		jteOutput.writeContent("\r\n<div class=\"content-wrapper\">\r\n  ");
		jteOutput.writeContent("\r\n  <section class=\"content-header\">\r\n    <div class=\"container-fluid\">\r\n      <div class=\"row mb-2\">\r\n        <div class=\"col-sm-6\">\r\n          <h1>Empleados</h1>\r\n        </div>\r\n        <div class=\"col-sm-6\">\r\n          <ol class=\"breadcrumb float-sm-right\">\r\n            <li class=\"breadcrumb-item\"><a href=\"/\">Inicio</a></li>\r\n            <li class=\"breadcrumb-item\"><a href=\"/empleados\">Empleados</a></li>\r\n            <li class=\"breadcrumb-item active\">Nuevo</li>\r\n          </ol>\r\n        </div>\r\n      </div>\r\n      ");
		if (modelo.exception != null) {
			jteOutput.writeContent("\r\n        <div class=\"alert alert-danger alert-dismissible fade show\" role=\"alert\">\r\n          ");
			jteOutput.setContext("div", null);
			jteOutput.writeUserContent(modelo.exception.getCause().getCause().getMessage());
			jteOutput.writeContent("\t\r\n          <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\">\r\n            <span aria-hidden=\"true\">&times;</span>\r\n          </button>\r\n        </div>\r\n      ");
		}
		jteOutput.writeContent("\r\n    </div>");
		jteOutput.writeContent("\r\n  </section>\r\n\r\n  ");
		jteOutput.writeContent("\r\n  <section class=\"content\">\r\n    <div class=\"container-fluid\">\r\n      <div class=\"row\">\r\n        <div class=\"col-12\">\r\n          ");
		jteOutput.writeContent("\r\n          <div class=\"card\">\r\n            <div class=\"card-header\">\r\n              <h3 class=\"card-title\">Crear Empleado</h3>\r\n            </div>\r\n            <form action=\"/empleados\" method=\"post\" id=\"empleado\">\r\n              <div class=\"card-body\">\r\n                <div class=\"form-group row\">\r\n                  <div class=\"col-4 input-group\">\r\n                    <div class=\"input-group-prepend\">\r\n                      <span class=\"input-group-text\">Legajo</span>\r\n                    </div>\r\n                    <input class=\"form-control\" type=\"text\" placeholder=\"Ingrese el legajo\" id=\"legajo\" required />\r\n                  </div>\r\n                  <div class=\"col-4 input-group\">\r\n                    <div class=\"input-group-prepend\">\r\n                      <span class=\"input-group-text\">CUIL</span>\r\n                    </div>\r\n                    <input class=\"form-control\" type=\"text\" placeholder=\"Ingrese el cuil\" id=\"cuil\" required />\r\n                  </div>\r\n                  <div class=\"col-4 input-group\">\r\n                    <div class=\"input-group-prepend\">\r\n                      <span class=\"input-group-text\">DNI</span>\r\n                    </div>\r\n                    <input class=\"form-control\" type=\"text\" id=\"dni\" required />\r\n                  </div>\r\n                </div>\r\n                <div class=\"form-group row\">\r\n                  <div class=\"col-12 input-group\">\r\n                    <div class=\"input-group-prepend\">\r\n                      <span class=\"input-group-text\">Nombre</span>\r\n                    </div>\r\n                    <input class=\"form-control\" type=\"text\" placeholder=\"Ingrese el nombre\" id=\"nombres\" required />\r\n                  </div>\r\n                </div>\r\n                <div class=\"form-group row\">\r\n                  <div class=\"col-12 input-group\">\r\n                    <div class=\"input-group-prepend\">\r\n                      <span class=\"input-group-text\">Apellido</span>\r\n                    </div>\r\n                    <input class=\"form-control\" type=\"text\" placeholder=\"Ingrese el apellido\" id=\"apellidos\" required />\r\n                  </div>\r\n                </div>\r\n                <div class=\"form-group row\">\r\n                  <div class=\"col-6 input-group\">\r\n                    <div class=\"input-group-prepend\">\r\n                      <span class=\"input-group-text\">Fecha Ingreso</span>\r\n                    </div>\r\n                    <input class=\"form-control\" type=\"date\" id=\"ingreso\" required />\r\n                  </div>\r\n                  <div class=\"col-6 input-group\">\r\n                    <div class=\"input-group-prepend\">\r\n                      <span class=\"input-group-text\">Fecha Nacimiento</span>\r\n                    </div>\r\n                    <input class=\"form-control\" type=\"date\" id=\"nacimiento\" required />\r\n                  </div>\r\n                </div>\r\n              </div>\r\n              ");
		jteOutput.writeContent("\r\n              <div class=\"card-footer\">\r\n                <button type=\"submit\" class=\"btn btn-primary\"><i class=\"fas fa-save\"></i> Guardar</button>\r\n                <a href=\".\" type=\"button\" class=\"btn btn-secondary\"> Volver </a>\r\n              </div>\r\n              ");
		jteOutput.writeContent("\r\n            </form>\r\n          </div>\r\n          ");
		jteOutput.writeContent("\r\n        </div>\r\n      </div>\r\n    </div>\r\n  </section>\r\n  ");
		jteOutput.writeContent("\r\n</div>\r\n");
		jteOutput.writeContent("\r\n\r\n<script src=\"/js/empleado/crear.js\"></script>\r\n\r\n");
		gg.jte.generated.ondemand.tag.JtefooterGenerated.render(jteOutput, jteHtmlInterceptor);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		edu.unam.jte.paginas.ModeloEmpleado modelo = (edu.unam.jte.paginas.ModeloEmpleado)params.get("modelo");
		render(jteOutput, jteHtmlInterceptor, modelo);
	}
}
