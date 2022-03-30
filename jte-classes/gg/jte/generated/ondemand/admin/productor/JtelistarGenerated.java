package gg.jte.generated.ondemand.admin.productor;
public final class JtelistarGenerated {
	public static final String JTE_NAME = "admin/productor/listar.jte";
	public static final int[] JTE_LINE_INFO = {0,0,0,0,2,2,2,4,4,6,8,16,16,17,17,19,19,19,24,24,25,25,30,30,30,31,31,31,31,31,31,31,42,42,49,49,50,50,51,51,52,52,54,54,54,59,59,60,60,61,64,69,92,92,94,94,94,95,95,95,96,96,96,97,97,97,100,100,100,104,104,104,109,109,114,116,121,123,127,127};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, edu.unam.jte.paginas.ModeloProductores modelo) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.tag.JteadminheadGenerated.render(jteOutput, jteHtmlInterceptor);
		jteOutput.writeContent("\n\n");
		gg.jte.generated.ondemand.tag.JteadminsidebarGenerated.render(jteOutput, jteHtmlInterceptor);
		jteOutput.writeContent("\n\n");
		jteOutput.writeContent("\n<div class=\"content-wrapper\">\n  ");
		jteOutput.writeContent("\n  <section class=\"content-header\">\n    <div class=\"container-fluid\">\n      <div class=\"row mb-2\">\n        <div class=\"col-sm-6\">\n          <h1>Productores</h1>\n        </div>\n      </div>\n      ");
		if (modelo.excepcion != null) {
			jteOutput.writeContent("\n        ");
			if (modelo.excepcion != "") {
				jteOutput.writeContent("\n          <div class=\"alert alert-danger alert-dismissible fade show\" role=\"alert\">\n            ");
				jteOutput.setContext("div", null);
				jteOutput.writeUserContent(modelo.excepcion);
				jteOutput.writeContent("\t\n            <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\">\n              <span aria-hidden=\"true\">&times;</span>\n            </button>\n          </div>\n        ");
			} else {
				jteOutput.writeContent("\n          ");
				if (modelo.eliminado != 0) {
					jteOutput.writeContent("\n            <form action=\"/admin/productores\" method=\"post\" id=\"form\">\n              <div class=\"alert alert-info alert-dismissible fade show\" role=\"alert\"\n              style=\"margin-bottom: 0px;padding-bottom: 0px;\">\n                <p>\n                  El productor con ID = ");
					jteOutput.setContext("p", null);
					jteOutput.writeUserContent(modelo.eliminado);
					jteOutput.writeContent(" se ha eliminado correctamente\n                  <input type=\"hidden\" id=\"id\"");
					if (gg.jte.runtime.TemplateUtils.isAttributeRendered(modelo.eliminado)) {
						jteOutput.writeContent(" value=\"");
						jteOutput.setContext("input", "value");
						jteOutput.writeUserContent(modelo.eliminado);
						jteOutput.writeContent("\"");
					}
					jteOutput.writeContent(" />\n                  <button type=\"submit\" class=\"btn btn-light btn-xs float-right\">\n                    <i class=\"fas fa-reply\"></i>\n                    Deshacer\n                  </button>\n                  <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\">\n                    <span aria-hidden=\"true\">&times;</span>\n                  </button>\n                </p>\n              </div>\n            </form>\n          ");
				} else {
					jteOutput.writeContent("\n            <div class=\"alert alert-success alert-dismissible fade show\" role=\"alert\">\n              El productor se ha actualizado correctamente\n              <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\">\n                <span aria-hidden=\"true\">&times;</span>\n              </button>\n            </div>\n          ");
				}
				jteOutput.writeContent("\n        ");
			}
			jteOutput.writeContent("\n      ");
		} else {
			jteOutput.writeContent("\n        ");
			if (modelo.eliminado != 0) {
				jteOutput.writeContent("\n          <div class=\"alert alert-dark alert-dismissible fade show\" role=\"alert\">\n            Se ha recuperado el productor con ID = ");
				jteOutput.setContext("div", null);
				jteOutput.writeUserContent(modelo.eliminado);
				jteOutput.writeContent("\n            <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\">\n              <span aria-hidden=\"true\">&times;</span>\n            </button>\n          </div>\n        ");
			}
			jteOutput.writeContent("\n      ");
		}
		jteOutput.writeContent("\n    </div>");
		jteOutput.writeContent("\n  </section>\n\n  ");
		jteOutput.writeContent("\n  <section class=\"content\">\n    <div class=\"container-fluid\">\n      <div class=\"row\">\n        <div class=\"col-12\">\n          ");
		jteOutput.writeContent("\n          <div class=\"card\">\n            <div class=\"card-header\">\n              <h3 class=\"card-title\">Lista de Productores</h3>\n              <div class=\"card-tools\">\n                <a href=\"/admin/productores/nuevo\" class=\"btn btn-primary btn-xs float-right\">\n                  <i class=\"fas fa-plus\"></i> Nuevo productor\n                </a>\n              </div>\n            </div>\n            <div class=\"card-body\">\n              <div class=\"table-responsive\">\n                <table class=\"table table-hover table-bordered\" id=\"data\">\n                  <thead class=\"bg-light\">\n                    <tr>\n                      <th scope=\"col\" style=\"width: 10%;\">#</th>\n                      <th scope=\"col\" style=\"width: 20%;\">CUIT</th>\n                      <th scope=\"col\" style=\"width: 20%;\">Apellidos</th>\n                      <th scope=\"col\" style=\"width: 20%;\">Nombres</th>\n                      <th scope=\"col\" style=\"width: 10%;\">Opciones</th>\n                    </tr>\n                  </thead>\n                  <tbody>\n                    ");
		for (var productor : modelo.productores) {
			jteOutput.writeContent("\n                      <tr>\n                        <td scope=\"row\">");
			jteOutput.setContext("td", null);
			jteOutput.writeUserContent(productor.getIdProductor());
			jteOutput.writeContent("</td>\n                        <td>");
			jteOutput.setContext("td", null);
			jteOutput.writeUserContent(productor.getCuit());
			jteOutput.writeContent("</td>\n                        <td>");
			jteOutput.setContext("td", null);
			jteOutput.writeUserContent(productor.getApellidos());
			jteOutput.writeContent("</td>\n                        <td>");
			jteOutput.setContext("td", null);
			jteOutput.writeUserContent(productor.getNombres());
			jteOutput.writeContent("</td>\n                        <td>\n                          <a type=\"button\" class=\"btn btn-warning btn-xs no-gutters\"\n                            href=\"/admin/productores/");
			jteOutput.setContext("a", "href");
			jteOutput.writeUserContent(productor.getIdProductor());
			jteOutput.writeContent("\">\n                            <i class=\"fas fa-edit\"></i>\n                          </a>\n                          <a type=\"button\" class=\"btn btn-danger btn-xs no-gutters\"\n                            onClick=\"borrar(&quot;productores&quot;,");
			jteOutput.setContext("a", "onClick");
			jteOutput.writeUserContent(productor.getIdProductor());
			jteOutput.writeContent(")\">\n                            <i class=\"fas fa-trash-alt\"></i>\n                          </a>\n                        </td>\n                      </tr>\n                    ");
		}
		jteOutput.writeContent("\n                  </tbody>\n                </table>\n              </div>\n            </div>\n            ");
		jteOutput.writeContent("\n          </div>\n          ");
		jteOutput.writeContent("\n        </div>\n      </div>\n    </div>\n  </section>\n  ");
		jteOutput.writeContent("\n</div>\n");
		jteOutput.writeContent("\n<script src=\"/js/borrar.js\"></script>\n<script src=\"/js/recuperar.js\"></script>\n\n");
		gg.jte.generated.ondemand.tag.JtefooterGenerated.render(jteOutput, jteHtmlInterceptor);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		edu.unam.jte.paginas.ModeloProductores modelo = (edu.unam.jte.paginas.ModeloProductores)params.get("modelo");
		render(jteOutput, jteHtmlInterceptor, modelo);
	}
}
