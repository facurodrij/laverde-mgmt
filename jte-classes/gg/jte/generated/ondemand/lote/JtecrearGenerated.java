package gg.jte.generated.ondemand.lote;
public final class JtecrearGenerated {
	public static final String JTE_NAME = "lote/crear.jte";
	public static final int[] JTE_LINE_INFO = {0,0,0,0,2,2,2,4,4,6,8,23,23,25,25,25,30,30,31,34,39,69,69,72,72,73,73,73,73,73,73,73,73,73,73,74,74,76,76,80,80,84,89,92,97,99,103,103};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, edu.unam.jte.paginas.ModeloLote modelo) {
		jteOutput.writeContent("\r\n");
		gg.jte.generated.ondemand.tag.JteheadGenerated.render(jteOutput, jteHtmlInterceptor);
		jteOutput.writeContent("\r\n\r\n");
		gg.jte.generated.ondemand.tag.JtesidebarGenerated.render(jteOutput, jteHtmlInterceptor);
		jteOutput.writeContent("\r\n\r\n");
		jteOutput.writeContent("\r\n<div class=\"content-wrapper\">\r\n  ");
		jteOutput.writeContent("\r\n  <section class=\"content-header\">\r\n    <div class=\"container-fluid\">\r\n      <div class=\"row mb-2\">\r\n        <div class=\"col-sm-6\">\r\n          <h1>Lotes</h1>\r\n        </div>\r\n        <div class=\"col-sm-6\">\r\n          <ol class=\"breadcrumb float-sm-right\">\r\n            <li class=\"breadcrumb-item\"><a href=\"/\">Inicio</a></li>\r\n            <li class=\"breadcrumb-item\"><a href=\"/lotes\">Lotes</a></li>\r\n            <li class=\"breadcrumb-item active\">Nuevo</li>\r\n          </ol>\r\n        </div>\r\n      </div>\r\n      ");
		if (modelo.exception != null) {
			jteOutput.writeContent("\r\n        <div class=\"alert alert-danger alert-dismissible fade show\" role=\"alert\">\r\n          ");
			jteOutput.setContext("div", null);
			jteOutput.writeUserContent(modelo.exception.getCause().getCause().getMessage());
			jteOutput.writeContent("\t\r\n          <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\">\r\n            <span aria-hidden=\"true\">&times;</span>\r\n          </button>\r\n        </div>\r\n      ");
		}
		jteOutput.writeContent("\r\n    </div>");
		jteOutput.writeContent("\r\n  </section>\r\n\r\n  ");
		jteOutput.writeContent("\r\n  <section class=\"content\">\r\n    <div class=\"container-fluid\">\r\n      <div class=\"row\">\r\n        <div class=\"col-12\">\r\n          ");
		jteOutput.writeContent("\r\n          <div class=\"card\">\r\n            <div class=\"card-header\">\r\n              <h3 class=\"card-title\">Crear Lote</h3>\r\n            </div>\r\n            <form action=\"/lotes\" method=\"post\" id=\"lote\">\r\n              <div class=\"card-body\">\r\n                <div class=\"form-group row\">\r\n                  <div class=\"col-9 input-group\">\r\n                    <div class=\"input-group-prepend\">\r\n                      <span class=\"input-group-text\">Punto 1</span>\r\n                    </div>\r\n                    <input class=\"form-control\" type=\"number\" placeholder=\"Ingrese la longitud\" id=\"punto1X\" required />\r\n                    <input class=\"form-control\" type=\"number\" placeholder=\"Ingrese la latitud\" id=\"punto1Y\" required />\r\n                  </div>\r\n                </div>\r\n                <div class=\"form-group row\">\r\n                  <div class=\"col-9 input-group\">\r\n                    <div class=\"input-group-prepend\">\r\n                      <span class=\"input-group-text\">Punto 2</span>\r\n                    </div>\r\n                    <input class=\"form-control\" type=\"number\" placeholder=\"Ingrese la longitud\" id=\"punto2X\" required />\r\n                    <input class=\"form-control\" type=\"number\" placeholder=\"Ingrese la latitud\" id=\"punto2Y\" required />\r\n                  </div>\r\n                </div>\r\n                <div class=\"form-group row\">\r\n                  <div class=\"col-9 input-group\">\r\n                    <div class=\"input-group-prepend\">\r\n                      <span class=\"input-group-text\">Productor</span>\r\n                    </div>\r\n                    ");
		if (!modelo.productores.isEmpty()) {
			jteOutput.writeContent("\r\n                    <select class=\"form-control\" id=\"productor\" required>\r\n                      <option value=\"\" hidden selected>Seleccione una opción</option>\r\n                      ");
			for (var productor : modelo.productores) {
				jteOutput.writeContent("\r\n                      <option");
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(productor.getIdProductor())) {
					jteOutput.writeContent(" value=\"");
					jteOutput.setContext("option", "value");
					jteOutput.writeUserContent(productor.getIdProductor());
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(">");
				jteOutput.setContext("option", null);
				jteOutput.writeUserContent(productor.toString());
				jteOutput.writeContent("</option>\r\n                      ");
			}
			jteOutput.writeContent("\r\n                    </select>\r\n                    ");
		} else {
			jteOutput.writeContent("\r\n                    <select class=\"form-control\" id=\"productor\" disabled>\r\n                      <option value=\"\" hidden selected>No hay productores</option>\r\n                    </select>\r\n                    ");
		}
		jteOutput.writeContent("\r\n                  </div>\r\n                </div>\r\n              </div>\r\n              ");
		jteOutput.writeContent("\r\n              <div class=\"card-footer\">\r\n                <button type=\"submit\" class=\"btn btn-primary\"><i class=\"fas fa-save\"></i> Guardar</button>\r\n                <a href=\".\" type=\"button\" class=\"btn btn-secondary\"> Volver </a>\r\n              </div>\r\n              ");
		jteOutput.writeContent("\r\n            </form>\r\n          </div>\r\n          ");
		jteOutput.writeContent("\r\n        </div>\r\n      </div>\r\n    </div>\r\n  </section>\r\n  ");
		jteOutput.writeContent("\r\n</div>\r\n");
		jteOutput.writeContent("\r\n\r\n<script src=\"/js/lote/crear.js\"></script>\r\n\r\n");
		gg.jte.generated.ondemand.tag.JtefooterGenerated.render(jteOutput, jteHtmlInterceptor);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		edu.unam.jte.paginas.ModeloLote modelo = (edu.unam.jte.paginas.ModeloLote)params.get("modelo");
		render(jteOutput, jteHtmlInterceptor, modelo);
	}
}
