package gg.jte.generated.ondemand.cuadro;
import edu.unam.jte.paginas.ModeloCuadros;
public final class JtelistarGenerated {
	public static final String JTE_NAME = "cuadro/listar.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,3,3,3,5,5,7,9,23,26,31,62,62,64,64,64,65,65,65,66,66,66,68,68,68,71,71,71,76,76,81,83,88,90,93,93};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, ModeloCuadros modelo) {
		jteOutput.writeContent("\r\n");
		gg.jte.generated.ondemand.tag.JteheadGenerated.render(jteOutput, jteHtmlInterceptor);
		jteOutput.writeContent("\r\n\r\n  ");
		gg.jte.generated.ondemand.tag.JtesidebarGenerated.render(jteOutput, jteHtmlInterceptor);
		jteOutput.writeContent("\r\n\r\n  ");
		jteOutput.writeContent("\r\n  <div class=\"content-wrapper\">\r\n    ");
		jteOutput.writeContent("\r\n    <section class=\"content-header\">\r\n      <div class=\"container-fluid\">\r\n        <div class=\"row mb-2\">\r\n          <div class=\"col-sm-6\">\r\n            <h1>Cuadros</h1>\r\n          </div>\r\n          <div class=\"col-sm-6\">\r\n            <ol class=\"breadcrumb float-sm-right\">\r\n              <li class=\"breadcrumb-item\"><a href=\"/\">Inicio</a></li>\r\n              <li class=\"breadcrumb-item active\">Cuadros</li>\r\n            </ol>\r\n          </div>\r\n        </div>\r\n      </div>");
		jteOutput.writeContent("\r\n    </section>\r\n\r\n    ");
		jteOutput.writeContent("\r\n    <section class=\"content\">\r\n      <div class=\"container-fluid\">\r\n        <div class=\"row\">\r\n          <div class=\"col-12\">\r\n            ");
		jteOutput.writeContent("\r\n            <div class=\"card\">\r\n              <div class=\"card-header\">\r\n                <h3 class=\"card-title\">Lista de Cuadros</h3>\r\n\r\n                <div class=\"card-tools\">\r\n                  <button type=\"button\" class=\"btn btn-tool\" data-card-widget=\"collapse\" title=\"Collapse\">\r\n                    <i class=\"fas fa-minus\"></i>\r\n                  </button>\r\n                  <button type=\"button\" class=\"btn btn-tool\" data-card-widget=\"remove\" title=\"Remove\">\r\n                    <i class=\"fas fa-times\"></i>\r\n                  </button>\r\n                </div>\r\n              </div>\r\n              <div class=\"card-body\">\r\n                <a href=\"/cuadros/nuevo\" class=\"btn btn-primary mb-3\">\r\n                    <i class=\"fas fa-plus\"></i> Nuevo cuadro\r\n                </a>\r\n                <a href=\"/\" type=\"button\" class=\"btn btn-secondary mb-3\"> Volver </a>\r\n                <div class=\"table-responsive\">\r\n                    <table class=\"table table-hover table-bordered\" id=\"data\">\r\n                        <thead class=\"bg-light\">\r\n                            <tr>\r\n                                <th scope=\"col\" style=\"width: 10%;\">#</th>\r\n                                <th scope=\"col\" style=\"width: 15%;\">Descripcion</th>\r\n                                <th scope=\"col\" style=\"width: 15%;\">Lote</th>\r\n                                <th scope=\"col\" style=\"width: 10%;\">Opciones</th>\r\n                            </tr>\r\n                        </thead>\r\n\r\n                        <tbody>\r\n                            ");
		for (var cuadro : modelo.cuadros) {
			jteOutput.writeContent("\r\n                                <tr>\r\n                                    <td scope=\"row\">");
			jteOutput.setContext("td", null);
			jteOutput.writeUserContent(cuadro.getIdCuadro());
			jteOutput.writeContent("</td>\r\n                                    <td>");
			jteOutput.setContext("td", null);
			jteOutput.writeUserContent(cuadro.getDescripcion());
			jteOutput.writeContent("</td>\r\n                                    <td>");
			jteOutput.setContext("td", null);
			jteOutput.writeUserContent(cuadro.getLote().toString());
			jteOutput.writeContent("</td>\r\n                                    <td>\r\n                                        <a type=\"button\" class=\"btn btn-warning btn-xs no-gutters\" href=\"/cuadros/");
			jteOutput.setContext("a", "href");
			jteOutput.writeUserContent(cuadro.getIdCuadro());
			jteOutput.writeContent("\">\r\n                                          <i class=\"fas fa-edit\"></i>\r\n                                        </a>\r\n                                        <a type=\"button\" class=\"btn btn-danger btn-xs no-gutters\" onClick=\"borrar(");
			jteOutput.setContext("a", "onClick");
			jteOutput.writeUserContent(cuadro.getIdCuadro());
			jteOutput.writeContent(")\">\r\n                                          <i class=\"fas fa-trash-alt\"></i>\r\n                                        </a>\r\n                                    </td>\r\n                                </tr>\r\n                            ");
		}
		jteOutput.writeContent("\r\n                        </tbody>\r\n                    </table>\r\n                </div>\r\n              </div>\r\n              ");
		jteOutput.writeContent("\r\n            </div>\r\n            ");
		jteOutput.writeContent("\r\n          </div>\r\n        </div>\r\n      </div>\r\n    </section>\r\n    ");
		jteOutput.writeContent("\r\n  </div>\r\n  ");
		jteOutput.writeContent("\r\n  <script src=\"/js/cuadro/borrar.js\"></script>\r\n\r\n");
		gg.jte.generated.ondemand.tag.JtefooterGenerated.render(jteOutput, jteHtmlInterceptor);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		ModeloCuadros modelo = (ModeloCuadros)params.get("modelo");
		render(jteOutput, jteHtmlInterceptor, modelo);
	}
}
