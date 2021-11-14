package gg.jte.generated.ondemand.productor;
public final class JteeditarGenerated {
	public static final String JTE_NAME = "productor/editar.jte";
	public static final int[] JTE_LINE_INFO = {0,0,0,0,2,2,2,4,4,6,8,19,19,19,23,26,31,45,45,45,52,52,52,52,52,52,52,60,60,60,60,60,60,60,68,68,68,68,68,68,68,72,77,80,85,87,89,89};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, edu.unam.jte.paginas.ModeloProductor modelo) {
		jteOutput.writeContent("\r\n");
		gg.jte.generated.ondemand.tag.JteheadGenerated.render(jteOutput, jteHtmlInterceptor);
		jteOutput.writeContent("\r\n\r\n");
		gg.jte.generated.ondemand.tag.JtesidebarGenerated.render(jteOutput, jteHtmlInterceptor);
		jteOutput.writeContent("\r\n\r\n");
		jteOutput.writeContent("\r\n  <div class=\"content-wrapper\">\r\n    ");
		jteOutput.writeContent("\r\n    <section class=\"content-header\">\r\n      <div class=\"container-fluid\">\r\n        <div class=\"row mb-2\">\r\n          <div class=\"col-sm-6\">\r\n            <h1>Productores</h1>\r\n          </div>\r\n          <div class=\"col-sm-6\">\r\n            <ol class=\"breadcrumb float-sm-right\">\r\n              <li class=\"breadcrumb-item\"><a href=\"/\">Inicio</a></li>\r\n              <li class=\"breadcrumb-item\"><a href=\"/productores\">Productores</a></li>\r\n              <li class=\"breadcrumb-item active\">");
		jteOutput.setContext("li", null);
		jteOutput.writeUserContent(modelo.productor.getNombres());
		jteOutput.writeContent("</li>\r\n            </ol>\r\n          </div>\r\n        </div>\r\n      </div>");
		jteOutput.writeContent("\r\n    </section>\r\n\r\n    ");
		jteOutput.writeContent("\r\n    <section class=\"content\">\r\n       <div class=\"container-fluid\">\r\n        <div class=\"row\">\r\n          <div class=\"col-12\">\r\n            ");
		jteOutput.writeContent("\r\n            <div class=\"card\">\r\n              <div class=\"card-header\">\r\n                <h3 class=\"card-title\">Editar Productor</h3>\r\n\r\n                <div class=\"card-tools\">\r\n                  <button type=\"button\" class=\"btn btn-tool\" data-card-widget=\"collapse\" title=\"Collapse\">\r\n                    <i class=\"fas fa-minus\"></i>\r\n                  </button>\r\n                  <button type=\"button\" class=\"btn btn-tool\" data-card-widget=\"remove\" title=\"Remove\">\r\n                    <i class=\"fas fa-times\"></i>\r\n                  </button>\r\n                </div>\r\n              </div>\r\n              <form action=\"/productores/");
		jteOutput.setContext("form", "action");
		jteOutput.writeUserContent(modelo.productor.getIdProductor());
		jteOutput.writeContent("\" method=\"post\">\r\n                    <div class=\"card-body\">\r\n                        <div class=\"form-group row\">\r\n                            <div class=\"col-6 input-group\">\r\n                                <div class=\"input-group-prepend\">\r\n                                    <span class=\"input-group-text\">CUIT</span>\r\n                                </div>\r\n                                <input class=\"form-control\" type=\"text\" placeholder=\"Ingrese el cuit\" name=\"cuit\"");
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(modelo.productor.getCuit())) {
			jteOutput.writeContent(" value=\"");
			jteOutput.setContext("input", "value");
			jteOutput.writeUserContent(modelo.productor.getCuit());
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent("/>\r\n                            </div>\r\n                        </div>\r\n                        <div class=\"form-group row\">\r\n                            <div class=\"col-12 input-group\">\r\n                                <div class=\"input-group-prepend\">\r\n                                    <span class=\"input-group-text\">Nombre</span>\r\n                                </div>\r\n                                <input class=\"form-control\" type=\"text\" placeholder=\"Ingrese el nombre\" name=\"nombres\"");
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(modelo.productor.getNombres())) {
			jteOutput.writeContent(" value=\"");
			jteOutput.setContext("input", "value");
			jteOutput.writeUserContent(modelo.productor.getNombres());
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent("/>\r\n                            </div>                            \r\n                        </div>\r\n                        <div class=\"form-group row\">\r\n                            <div class=\"col-12 input-group\">\r\n                                <div class=\"input-group-prepend\">\r\n                                    <span class=\"input-group-text\">Apellido</span>\r\n                                </div>\r\n                                <input class=\"form-control\" type=\"text\" placeholder=\"Ingrese el apellido\" name=\"apellidos\"");
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(modelo.productor.getApellidos())) {
			jteOutput.writeContent(" value=\"");
			jteOutput.setContext("input", "value");
			jteOutput.writeUserContent(modelo.productor.getApellidos());
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent("/>\r\n                            </div>\r\n                        </div>\r\n                    </div>\r\n                    ");
		jteOutput.writeContent("\r\n                    <div class=\"card-footer\">\r\n                        <button type=\"submit\" class=\"btn btn-primary\"><i class=\"fas fa-save\"></i> Guardar</button>\r\n                        <a href=\".\" type=\"button\" class=\"btn btn-secondary\"> Volver </a>\r\n                    </div>\r\n                  ");
		jteOutput.writeContent("\r\n              </form>\r\n            </div>\r\n            ");
		jteOutput.writeContent("\r\n          </div>\r\n        </div>\r\n      </div>\r\n    </section>\r\n    ");
		jteOutput.writeContent("\r\n  </div>\r\n");
		jteOutput.writeContent("\r\n\r\n");
		gg.jte.generated.ondemand.tag.JtefooterGenerated.render(jteOutput, jteHtmlInterceptor);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		edu.unam.jte.paginas.ModeloProductor modelo = (edu.unam.jte.paginas.ModeloProductor)params.get("modelo");
		render(jteOutput, jteHtmlInterceptor, modelo);
	}
}
