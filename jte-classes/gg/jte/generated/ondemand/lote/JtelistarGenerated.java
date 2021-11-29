package gg.jte.generated.ondemand.lote;
public final class JtelistarGenerated {
	public static final String JTE_NAME = "lote/listar.jte";
	public static final int[] JTE_LINE_INFO = {0,0,0,0,2,2,2,4,4,6,8,22,22,24,24,24,29,29,30,33,38,67,67,69,69,69,70,70,70,71,71,71,72,72,72,74,74,74,77,77,77,82,82,87,89,94,96,99,99};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, edu.unam.jte.paginas.ModeloLote modelo) {
		jteOutput.writeContent("\r\n");
		gg.jte.generated.ondemand.tag.JteheadGenerated.render(jteOutput, jteHtmlInterceptor);
		jteOutput.writeContent("\r\n\r\n");
		gg.jte.generated.ondemand.tag.JtesidebarGenerated.render(jteOutput, jteHtmlInterceptor);
		jteOutput.writeContent("\r\n\r\n");
		jteOutput.writeContent("\r\n<div class=\"content-wrapper\">\r\n  ");
		jteOutput.writeContent("\r\n  <section class=\"content-header\">\r\n    <div class=\"container-fluid\">\r\n      <div class=\"row mb-2\">\r\n        <div class=\"col-sm-6\">\r\n          <h1>Lotes</h1>\r\n        </div>\r\n        <div class=\"col-sm-6\">\r\n          <ol class=\"breadcrumb float-sm-right\">\r\n            <li class=\"breadcrumb-item\"><a href=\"/\">Inicio</a></li>\r\n            <li class=\"breadcrumb-item active\">Lotes</li>\r\n          </ol>\r\n        </div>\r\n      </div>\r\n      ");
		if (modelo.exception != null) {
			jteOutput.writeContent("\r\n        <div class=\"alert alert-danger alert-dismissible fade show\" role=\"alert\">\r\n          ");
			jteOutput.setContext("div", null);
			jteOutput.writeUserContent(modelo.exception.getCause().getCause().getMessage());
			jteOutput.writeContent("\t\r\n          <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\">\r\n            <span aria-hidden=\"true\">&times;</span>\r\n          </button>\r\n        </div>\r\n      ");
		}
		jteOutput.writeContent("\r\n    </div>");
		jteOutput.writeContent("\r\n  </section>\r\n\r\n  ");
		jteOutput.writeContent("\r\n  <section class=\"content\">\r\n    <div class=\"container-fluid\">\r\n      <div class=\"row\">\r\n        <div class=\"col-12\">\r\n          ");
		jteOutput.writeContent("\r\n          <div class=\"card\">\r\n            <div class=\"card-header\">\r\n              <h3 class=\"card-title\">Lista de Lotes</h3>\r\n\r\n              <div class=\"card-tools\">\r\n                <button type=\"button\" class=\"btn btn-tool\" data-card-widget=\"collapse\" title=\"Collapse\">\r\n                  <i class=\"fas fa-minus\"></i>\r\n                </button>\r\n              </div>\r\n            </div>\r\n            <div class=\"card-body\">\r\n              <a href=\"/lotes/nuevo\" class=\"btn btn-primary mb-3\">\r\n                <i class=\"fas fa-plus\"></i> Nuevo lote\r\n              </a>\r\n              <a href=\"/\" type=\"button\" class=\"btn btn-secondary mb-3\"> Volver </a>\r\n              <div class=\"table-responsive\">\r\n                <table class=\"table table-hover table-bordered\" id=\"data\">\r\n                  <thead class=\"bg-light\">\r\n                    <tr>\r\n                      <th scope=\"col\" style=\"width: 10%;\">#</th>\r\n                      <th scope=\"col\" style=\"width: 15%;\">Punto 1</th>\r\n                      <th scope=\"col\" style=\"width: 15%;\">Punto 2</th>\r\n                      <th scope=\"col\" style=\"width: 50%;\">Productor</th>\r\n                      <th scope=\"col\" style=\"width: 10%;\">Opciones</th>\r\n                    </tr>\r\n                  </thead>\r\n\r\n                  <tbody>\r\n                    ");
		for (var lote : modelo.lotes) {
			jteOutput.writeContent("\r\n                    <tr>\r\n                      <td scope=\"row\">");
			jteOutput.setContext("td", null);
			jteOutput.writeUserContent(lote.getIdLote());
			jteOutput.writeContent("</td>\r\n                      <td>");
			jteOutput.setContext("td", null);
			jteOutput.writeUserContent(lote.punto1_ToString());
			jteOutput.writeContent("</td>\r\n                      <td>");
			jteOutput.setContext("td", null);
			jteOutput.writeUserContent(lote.punto2_ToString());
			jteOutput.writeContent("</td>\r\n                      <td>");
			jteOutput.setContext("td", null);
			jteOutput.writeUserContent(lote.getProductor().toString());
			jteOutput.writeContent("</td>\r\n                      <td>\r\n                        <a type=\"button\" class=\"btn btn-warning btn-xs no-gutters\" href=\"/lotes/");
			jteOutput.setContext("a", "href");
			jteOutput.writeUserContent(lote.getIdLote());
			jteOutput.writeContent("\">\r\n                          <i class=\"fas fa-edit\"></i>\r\n                        </a>\r\n                        <a type=\"button\" class=\"btn btn-danger btn-xs no-gutters\" onClick=\"borrar(");
			jteOutput.setContext("a", "onClick");
			jteOutput.writeUserContent(lote.getIdLote());
			jteOutput.writeContent(")\">\r\n                          <i class=\"fas fa-trash-alt\"></i>\r\n                        </a>\r\n                      </td>\r\n                    </tr>\r\n                    ");
		}
		jteOutput.writeContent("\r\n                  </tbody>\r\n                </table>\r\n              </div>\r\n            </div>\r\n            ");
		jteOutput.writeContent("\r\n          </div>\r\n          ");
		jteOutput.writeContent("\r\n        </div>\r\n      </div>\r\n    </div>\r\n  </section>\r\n  ");
		jteOutput.writeContent("\r\n</div>\r\n");
		jteOutput.writeContent("\r\n<script src=\"/js/lote/borrar.js\"></script>\r\n\r\n");
		gg.jte.generated.ondemand.tag.JtefooterGenerated.render(jteOutput, jteHtmlInterceptor);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		edu.unam.jte.paginas.ModeloLote modelo = (edu.unam.jte.paginas.ModeloLote)params.get("modelo");
		render(jteOutput, jteHtmlInterceptor, modelo);
	}
}
