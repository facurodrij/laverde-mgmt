package gg.jte.generated.ondemand.lote;
public final class JteeditarGenerated {
	public static final String JTE_NAME = "lote/editar.jte";
	public static final int[] JTE_LINE_INFO = {0,0,0,0,2,2,2,4,4,6,8,19,19,19,23,23,25,25,25,30,30,31,34,39,44,44,44,45,45,45,45,45,45,45,53,53,53,53,53,53,53,55,55,55,55,55,55,55,64,64,64,64,64,64,64,66,66,66,66,66,66,66,75,75,76,76,77,77,77,77,77,77,77,77,77,77,78,78,79,79,79,79,79,79,79,79,79,79,80,80,81,81,86,91,94,99,101,105,105};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, edu.unam.jte.paginas.ModeloLote modelo) {
		jteOutput.writeContent("\r\n");
		gg.jte.generated.ondemand.tag.JteheadGenerated.render(jteOutput, jteHtmlInterceptor);
		jteOutput.writeContent("\r\n\r\n");
		gg.jte.generated.ondemand.tag.JtesidebarGenerated.render(jteOutput, jteHtmlInterceptor);
		jteOutput.writeContent("\r\n\r\n");
		jteOutput.writeContent("\r\n<div class=\"content-wrapper\">\r\n  ");
		jteOutput.writeContent("\r\n  <section class=\"content-header\">\r\n    <div class=\"container-fluid\">\r\n      <div class=\"row mb-2\">\r\n        <div class=\"col-sm-6\">\r\n          <h1>Lotes</h1>\r\n        </div>\r\n        <div class=\"col-sm-6\">\r\n          <ol class=\"breadcrumb float-sm-right\">\r\n            <li class=\"breadcrumb-item\"><a href=\"/\">Inicio</a></li>\r\n            <li class=\"breadcrumb-item\"><a href=\"/lotes\">Lotes</a></li>\r\n            <li class=\"breadcrumb-item active\">");
		jteOutput.setContext("li", null);
		jteOutput.writeUserContent(modelo.lote.getIdLote());
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
		jteOutput.writeContent("\r\n          <div class=\"card\">\r\n            <div class=\"card-header\">\r\n              <h3 class=\"card-title\">Editar Lote</h3>\r\n            </div>\r\n            <form action=\"/lotes/");
		jteOutput.setContext("form", "action");
		jteOutput.writeUserContent(modelo.lote.getIdLote());
		jteOutput.writeContent("\" method=\"post\" id=\"lote\">\r\n              <input class=\"form-control\" type=\"hidden\" id=\"idLote\"");
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(modelo.lote.getIdLote())) {
			jteOutput.writeContent(" value=\"");
			jteOutput.setContext("input", "value");
			jteOutput.writeUserContent(modelo.lote.getIdLote());
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(" />\r\n              <div class=\"card-body\">\r\n                <div class=\"form-group row\">\r\n                  <div class=\"col-9 input-group\">\r\n                    <div class=\"input-group-prepend\">\r\n                      <span class=\"input-group-text\">Punto 1</span>\r\n                    </div>\r\n                    <input class=\"form-control\" type=\"number\" placeholder=\"Ingrese la longitud\" id=\"punto1X\"");
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered((modelo.lote.getPunto1())[0])) {
			jteOutput.writeContent(" value=\"");
			jteOutput.setContext("input", "value");
			jteOutput.writeUserContent((modelo.lote.getPunto1())[0]);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(" required />\r\n                    <input class=\"form-control\" type=\"number\" placeholder=\"Ingrese la latitud\" id=\"punto1Y\"");
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered((modelo.lote.getPunto1())[1])) {
			jteOutput.writeContent(" value=\"");
			jteOutput.setContext("input", "value");
			jteOutput.writeUserContent((modelo.lote.getPunto1())[1]);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(" required />\r\n                  </div>\r\n                </div>\r\n                <div class=\"form-group row\">\r\n                  <div class=\"col-9 input-group\">\r\n                    <div class=\"input-group-prepend\">\r\n                      <span class=\"input-group-text\">Punto 2</span>\r\n                    </div>\r\n                    <input class=\"form-control\" type=\"number\" placeholder=\"Ingrese la longitud\" id=\"punto2X\"");
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered((modelo.lote.getPunto2())[0])) {
			jteOutput.writeContent(" value=\"");
			jteOutput.setContext("input", "value");
			jteOutput.writeUserContent((modelo.lote.getPunto2())[0]);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(" required />\r\n                    <input class=\"form-control\" type=\"number\" placeholder=\"Ingrese la latitud\" id=\"punto2Y\"");
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered((modelo.lote.getPunto2())[1])) {
			jteOutput.writeContent(" value=\"");
			jteOutput.setContext("input", "value");
			jteOutput.writeUserContent((modelo.lote.getPunto2())[1]);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(" required />\r\n                  </div>\r\n                </div>\r\n                <div class=\"form-group row\">\r\n                  <div class=\"col-9 input-group\">\r\n                    <div class=\"input-group-prepend\">\r\n                      <span class=\"input-group-text\">Productor</span>\r\n                    </div>\r\n                    <select class=\"form-control\" id=\"productor\" required>\r\n                      ");
		for (var productor : modelo.productores) {
			jteOutput.writeContent("\r\n                      ");
			if (productor.getIdProductor() == modelo.lote.getProductor().getIdProductor()) {
				jteOutput.writeContent("\r\n                      <option");
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(productor.getIdProductor())) {
					jteOutput.writeContent(" value=\"");
					jteOutput.setContext("option", "value");
					jteOutput.writeUserContent(productor.getIdProductor());
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" selected>");
				jteOutput.setContext("option", null);
				jteOutput.writeUserContent(productor.toString());
				jteOutput.writeContent("</option>\r\n                      ");
			} else {
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
			jteOutput.writeContent("\r\n                      ");
		}
		jteOutput.writeContent("\r\n                    </select>\r\n                  </div>\r\n                </div>\r\n              </div>\r\n              ");
		jteOutput.writeContent("\r\n              <div class=\"card-footer\">\r\n                <button type=\"submit\" class=\"btn btn-primary\"><i class=\"fas fa-save\"></i> Guardar</button>\r\n                <a href=\".\" type=\"button\" class=\"btn btn-secondary\"> Volver </a>\r\n              </div>\r\n              ");
		jteOutput.writeContent("\r\n            </form>\r\n          </div>\r\n          ");
		jteOutput.writeContent("\r\n        </div>\r\n      </div>\r\n    </div>\r\n  </section>\r\n  ");
		jteOutput.writeContent("\r\n</div>\r\n");
		jteOutput.writeContent("\r\n\r\n<script src=\"/js/lote/actualizar.js\"></script>\r\n\r\n");
		gg.jte.generated.ondemand.tag.JtefooterGenerated.render(jteOutput, jteHtmlInterceptor);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		edu.unam.jte.paginas.ModeloLote modelo = (edu.unam.jte.paginas.ModeloLote)params.get("modelo");
		render(jteOutput, jteHtmlInterceptor, modelo);
	}
}