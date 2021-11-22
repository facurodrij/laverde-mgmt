package gg.jte.generated.ondemand.lote;
import edu.unam.jte.paginas.ModeloProductores;
public final class JtecrearGenerated {
	public static final String JTE_NAME = "lote/crear.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,3,3,3,5,5,7,9,24,27,32,72,72,73,73,73,73,73,73,73,73,73,73,74,74,79,84,87,92,94,98,98};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, ModeloProductores modelo) {
		jteOutput.writeContent("\r\n");
		gg.jte.generated.ondemand.tag.JteheadGenerated.render(jteOutput, jteHtmlInterceptor);
		jteOutput.writeContent("\r\n\r\n");
		gg.jte.generated.ondemand.tag.JtesidebarGenerated.render(jteOutput, jteHtmlInterceptor);
		jteOutput.writeContent("\r\n\r\n");
		jteOutput.writeContent("\r\n  <div class=\"content-wrapper\">\r\n    ");
		jteOutput.writeContent("\r\n    <section class=\"content-header\">\r\n      <div class=\"container-fluid\">\r\n        <div class=\"row mb-2\">\r\n          <div class=\"col-sm-6\">\r\n            <h1>Lotes</h1>\r\n          </div>\r\n          <div class=\"col-sm-6\">\r\n            <ol class=\"breadcrumb float-sm-right\">\r\n              <li class=\"breadcrumb-item\"><a href=\"/\">Inicio</a></li>\r\n              <li class=\"breadcrumb-item\"><a href=\"/lotes\">Lotes</a></li>\r\n              <li class=\"breadcrumb-item active\">Nuevo</li>\r\n            </ol>\r\n          </div>\r\n        </div>\r\n      </div>");
		jteOutput.writeContent("\r\n    </section>\r\n\r\n    ");
		jteOutput.writeContent("\r\n    <section class=\"content\">\r\n        <div class=\"container-fluid\">\r\n            <div class=\"row\">\r\n            <div class=\"col-12\">\r\n                ");
		jteOutput.writeContent("\r\n                <div class=\"card\">\r\n                <div class=\"card-header\">\r\n                    <h3 class=\"card-title\">Crear Lote</h3>\r\n\r\n                    <div class=\"card-tools\">\r\n                    <button type=\"button\" class=\"btn btn-tool\" data-card-widget=\"collapse\" title=\"Collapse\">\r\n                        <i class=\"fas fa-minus\"></i>\r\n                    </button>\r\n                    <button type=\"button\" class=\"btn btn-tool\" data-card-widget=\"remove\" title=\"Remove\">\r\n                        <i class=\"fas fa-times\"></i>\r\n                    </button>\r\n                    </div>\r\n                </div>\r\n                <form action=\"/lotes\" method=\"post\" id=\"lote\">\r\n                    <div class=\"card-body\">\r\n                        <div class=\"form-group row\">\r\n                            <div class=\"col-9 input-group\">\r\n                                <div class=\"input-group-prepend\">\r\n                                    <span class=\"input-group-text\">Punto 1</span>\r\n                                </div>\r\n                                <input class=\"form-control\" type=\"number\" placeholder=\"Ingrese la longitud\" id=\"punto1X\" required/>\r\n                                <input class=\"form-control\" type=\"number\" placeholder=\"Ingrese la latitud\" id=\"punto1Y\" required/>\r\n                            </div>\r\n                        </div>\r\n                        <div class=\"form-group row\">\r\n                            <div class=\"col-9 input-group\">\r\n                                <div class=\"input-group-prepend\">\r\n                                    <span class=\"input-group-text\">Punto 2</span>\r\n                                </div>\r\n                                <input class=\"form-control\" type=\"number\" placeholder=\"Ingrese la longitud\" id=\"punto2X\" required/>\r\n                                <input class=\"form-control\" type=\"number\" placeholder=\"Ingrese la latitud\" id=\"punto2Y\" required/>\r\n                            </div>                            \r\n                        </div>\r\n                        <div class=\"form-group row\">\r\n                            <div class=\"col-9 input-group\">\r\n                                <div class=\"input-group-prepend\">\r\n                                    <span class=\"input-group-text\">Productor</span>\r\n                                </div>\r\n                                <select class=\"form-control\" id=\"productor\" required>\r\n                                    ");
		for (var productor : modelo.productores) {
			jteOutput.writeContent("\r\n                                        <option");
			if (gg.jte.runtime.TemplateUtils.isAttributeRendered(productor.getIdProductor())) {
				jteOutput.writeContent(" value=\"");
				jteOutput.setContext("option", "value");
				jteOutput.writeUserContent(productor.getIdProductor());
				jteOutput.writeContent("\"");
			}
			jteOutput.writeContent(">");
			jteOutput.setContext("option", null);
			jteOutput.writeUserContent(productor.toString());
			jteOutput.writeContent("</option>\r\n                                    ");
		}
		jteOutput.writeContent("\r\n                                </select>\r\n                            </div>\r\n                        </div>\r\n                    </div>\r\n                    ");
		jteOutput.writeContent("\r\n                    <div class=\"card-footer\">\r\n                        <button type=\"submit\" class=\"btn btn-primary\"><i class=\"fas fa-save\"></i> Guardar</button>\r\n                        <a href=\".\" type=\"button\" class=\"btn btn-secondary\"> Volver </a>\r\n                    </div>\r\n                    ");
		jteOutput.writeContent("\r\n                </form>\r\n            </div>\r\n            ");
		jteOutput.writeContent("\r\n          </div>\r\n        </div>\r\n      </div>\r\n    </section>\r\n    ");
		jteOutput.writeContent("\r\n  </div>\r\n");
		jteOutput.writeContent("\r\n\r\n<script src=\"/js/lote/crear.js\"></script>\r\n\r\n");
		gg.jte.generated.ondemand.tag.JtefooterGenerated.render(jteOutput, jteHtmlInterceptor);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		ModeloProductores modelo = (ModeloProductores)params.get("modelo");
		render(jteOutput, jteHtmlInterceptor, modelo);
	}
}
