package gg.jte.generated.ondemand.cuadro;
import edu.unam.jte.paginas.ModeloLotes;
public final class JtecrearGenerated {
	public static final String JTE_NAME = "cuadro/crear.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,3,3,3,5,5,7,9,24,27,32,61,61,64,64,65,65,65,65,65,65,65,65,65,65,66,66,68,68,72,72,76,81,84,89,91,95,95};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, ModeloLotes modelo) {
		jteOutput.writeContent("\r\n");
		gg.jte.generated.ondemand.tag.JteheadGenerated.render(jteOutput, jteHtmlInterceptor);
		jteOutput.writeContent("\r\n\r\n");
		gg.jte.generated.ondemand.tag.JtesidebarGenerated.render(jteOutput, jteHtmlInterceptor);
		jteOutput.writeContent("\r\n\r\n");
		jteOutput.writeContent("\r\n  <div class=\"content-wrapper\">\r\n    ");
		jteOutput.writeContent("\r\n    <section class=\"content-header\">\r\n      <div class=\"container-fluid\">\r\n        <div class=\"row mb-2\">\r\n          <div class=\"col-sm-6\">\r\n      <h1>Cuadros</h1>\r\n          </div>\r\n          <div class=\"col-sm-6\">\r\n            <ol class=\"breadcrumb float-sm-right\">\r\n              <li class=\"breadcrumb-item\"><a href=\"/\">Inicio</a></li>\r\n              <li class=\"breadcrumb-item\"><a href=\"/cuadros\">Cuadros</a></li>\r\n              <li class=\"breadcrumb-item active\">Nuevo</li>\r\n            </ol>\r\n          </div>\r\n        </div>\r\n      </div>");
		jteOutput.writeContent("\r\n    </section>\r\n\r\n    ");
		jteOutput.writeContent("\r\n    <section class=\"content\">\r\n        <div class=\"container-fluid\">\r\n            <div class=\"row\">\r\n            <div class=\"col-12\">\r\n                ");
		jteOutput.writeContent("\r\n                <div class=\"card\">\r\n                <div class=\"card-header\">\r\n                    <h3 class=\"card-title\">Crear Cuadro</h3>\r\n\r\n                    <div class=\"card-tools\">\r\n                    <button type=\"button\" class=\"btn btn-tool\" data-card-widget=\"collapse\" title=\"Collapse\">\r\n                        <i class=\"fas fa-minus\"></i>\r\n                    </button>\r\n                    <button type=\"button\" class=\"btn btn-tool\" data-card-widget=\"remove\" title=\"Remove\">\r\n                        <i class=\"fas fa-times\"></i>\r\n                    </button>\r\n                    </div>\r\n                </div>\r\n                <form action=\"/cuadros\" method=\"post\" id=\"cuadro\">\r\n                    <div class=\"card-body\">\r\n                        <div class=\"form-group row\">\r\n                            <div class=\"col-9 input-group\">\r\n                                <div class=\"input-group-prepend\">\r\n                                    <span class=\"input-group-text\">Descripcion</span>\r\n                                </div>\r\n                                <input class=\"form-control\" type=\"textarea\" placeholder=\"Ingrese la descripcion\" id=\"descripcion\" required/>\r\n                            </div>\r\n                        </div>\r\n                        <div class=\"form-group row\">\r\n                            <div class=\"col-9 input-group\">\r\n                                <div class=\"input-group-prepend\">\r\n                                    <span class=\"input-group-text\">Lote</span>\r\n                                </div>\r\n                                ");
		if (!modelo.lotes.isEmpty()) {
			jteOutput.writeContent("\r\n                                  <select class=\"form-control\" id=\"lote\" required>\r\n                                    <option hidden selected>Seleccione una opción</option>\r\n                                    ");
			for (var lote : modelo.lotes) {
				jteOutput.writeContent("\r\n                                      <option");
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(lote.getIdLote())) {
					jteOutput.writeContent(" value=\"");
					jteOutput.setContext("option", "value");
					jteOutput.writeUserContent(lote.getIdLote());
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(">");
				jteOutput.setContext("option", null);
				jteOutput.writeUserContent(lote.toString());
				jteOutput.writeContent("</option>\r\n                                    ");
			}
			jteOutput.writeContent("\r\n                                  </select>\r\n                                ");
		} else {
			jteOutput.writeContent("\r\n                                  <select class=\"form-control\" id=\"lote\" disabled>\r\n                                    <option hidden selected>No hay lotes</option>\r\n                                  </select>\r\n                                ");
		}
		jteOutput.writeContent("\r\n                            </div>\r\n                        </div>\r\n                    </div>\r\n                    ");
		jteOutput.writeContent("\r\n                    <div class=\"card-footer\">\r\n                        <button type=\"submit\" class=\"btn btn-primary\"><i class=\"fas fa-save\"></i> Guardar</button>\r\n                        <a href=\".\" type=\"button\" class=\"btn btn-secondary\"> Volver </a>\r\n                    </div>\r\n                    ");
		jteOutput.writeContent("\r\n                </form>\r\n            </div>\r\n            ");
		jteOutput.writeContent("\r\n          </div>\r\n        </div>\r\n      </div>\r\n    </section>\r\n    ");
		jteOutput.writeContent("\r\n  </div>\r\n");
		jteOutput.writeContent("\r\n\r\n<script src=\"/js/cuadro/crear.js\"></script>\r\n\r\n");
		gg.jte.generated.ondemand.tag.JtefooterGenerated.render(jteOutput, jteHtmlInterceptor);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		ModeloLotes modelo = (ModeloLotes)params.get("modelo");
		render(jteOutput, jteHtmlInterceptor, modelo);
	}
}
