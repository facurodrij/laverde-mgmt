package gg.jte.generated.ondemand.cuadro;
public final class JteeditarGenerated {
	public static final String JTE_NAME = "cuadro/editar.jte";
	public static final int[] JTE_LINE_INFO = {0,0,0,0,2,2,2,4,4,6,8,19,19,19,23,26,31,45,45,45,46,46,46,46,46,46,46,54,54,54,54,54,54,54,63,63,64,64,65,65,65,65,65,65,65,65,65,65,66,66,67,67,67,67,67,67,67,67,67,67,68,68,69,69,74,79,82,87,89,93,93};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, edu.unam.jte.paginas.ModeloCuadro modelo) {
		jteOutput.writeContent("\r\n");
		gg.jte.generated.ondemand.tag.JteheadGenerated.render(jteOutput, jteHtmlInterceptor);
		jteOutput.writeContent("\r\n\r\n");
		gg.jte.generated.ondemand.tag.JtesidebarGenerated.render(jteOutput, jteHtmlInterceptor);
		jteOutput.writeContent("\r\n\r\n");
		jteOutput.writeContent("\r\n<div class=\"content-wrapper\">\r\n  ");
		jteOutput.writeContent("\r\n  <section class=\"content-header\">\r\n    <div class=\"container-fluid\">\r\n      <div class=\"row mb-2\">\r\n        <div class=\"col-sm-6\">\r\n          <h1>Cuadros</h1>\r\n        </div>\r\n        <div class=\"col-sm-6\">\r\n          <ol class=\"breadcrumb float-sm-right\">\r\n            <li class=\"breadcrumb-item\"><a href=\"/\">Inicio</a></li>\r\n            <li class=\"breadcrumb-item\"><a href=\"/cuadros\">Cuadros</a></li>\r\n            <li class=\"breadcrumb-item active\">");
		jteOutput.setContext("li", null);
		jteOutput.writeUserContent(modelo.cuadro.getIdCuadro());
		jteOutput.writeContent("</li>\r\n          </ol>\r\n        </div>\r\n      </div>\r\n    </div>");
		jteOutput.writeContent("\r\n  </section>\r\n\r\n  ");
		jteOutput.writeContent("\r\n  <section class=\"content\">\r\n    <div class=\"container-fluid\">\r\n      <div class=\"row\">\r\n        <div class=\"col-12\">\r\n          ");
		jteOutput.writeContent("\r\n          <div class=\"card\">\r\n            <div class=\"card-header\">\r\n              <h3 class=\"card-title\">Editar Cuadro</h3>\r\n\r\n              <div class=\"card-tools\">\r\n                <button type=\"button\" class=\"btn btn-tool\" data-card-widget=\"collapse\" title=\"Collapse\">\r\n                  <i class=\"fas fa-minus\"></i>\r\n                </button>\r\n                <button type=\"button\" class=\"btn btn-tool\" data-card-widget=\"remove\" title=\"Remove\">\r\n                  <i class=\"fas fa-times\"></i>\r\n                </button>\r\n              </div>\r\n            </div>\r\n            <form action=\"/cuadros/");
		jteOutput.setContext("form", "action");
		jteOutput.writeUserContent(modelo.cuadro.getIdCuadro());
		jteOutput.writeContent("\" method=\"post\" id=\"cuadro\">\r\n              <input class=\"form-control\" type=\"hidden\" id=\"idCuadro\"");
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(modelo.cuadro.getIdCuadro())) {
			jteOutput.writeContent(" value=\"");
			jteOutput.setContext("input", "value");
			jteOutput.writeUserContent(modelo.cuadro.getIdCuadro());
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(" />\r\n              <div class=\"card-body\">\r\n                <div class=\"form-group row\">\r\n                  <div class=\"col-9 input-group\">\r\n                    <div class=\"input-group-prepend\">\r\n                      <span class=\"input-group-text\">Descripcion</span>\r\n                    </div>\r\n                    <input class=\"form-control\" type=\"textarea\" placeholder=\"Ingrese la descripcion\" id=\"descripcion\"");
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(modelo.cuadro.getDescripcion())) {
			jteOutput.writeContent(" value=\"");
			jteOutput.setContext("input", "value");
			jteOutput.writeUserContent(modelo.cuadro.getDescripcion());
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(" required />\r\n                  </div>\r\n                </div>\r\n                <div class=\"form-group row\">\r\n                  <div class=\"col-9 input-group\">\r\n                    <div class=\"input-group-prepend\">\r\n                      <span class=\"input-group-text\">Lote</span>\r\n                    </div>\r\n                    <select class=\"form-control\" id=\"lote\" required>\r\n                      ");
		for (var lote : modelo.lotes) {
			jteOutput.writeContent("\r\n                      ");
			if (lote.getIdLote() == modelo.cuadro.getLote().getIdLote()) {
				jteOutput.writeContent("\r\n                      <option");
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(lote.getIdLote())) {
					jteOutput.writeContent(" value=\"");
					jteOutput.setContext("option", "value");
					jteOutput.writeUserContent(lote.getIdLote());
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" selected>");
				jteOutput.setContext("option", null);
				jteOutput.writeUserContent(lote.toString());
				jteOutput.writeContent("</option>\r\n                      ");
			} else {
				jteOutput.writeContent("\r\n                      <option");
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(lote.getIdLote())) {
					jteOutput.writeContent(" value=\"");
					jteOutput.setContext("option", "value");
					jteOutput.writeUserContent(lote.getIdLote());
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(">");
				jteOutput.setContext("option", null);
				jteOutput.writeUserContent(lote.toString());
				jteOutput.writeContent("</option>\r\n                      ");
			}
			jteOutput.writeContent("\r\n                      ");
		}
		jteOutput.writeContent("\r\n                    </select>\r\n                  </div>\r\n                </div>\r\n              </div>\r\n              ");
		jteOutput.writeContent("\r\n              <div class=\"card-footer\">\r\n                <button type=\"submit\" class=\"btn btn-primary\"><i class=\"fas fa-save\"></i> Guardar</button>\r\n                <a href=\".\" type=\"button\" class=\"btn btn-secondary\"> Volver </a>\r\n              </div>\r\n              ");
		jteOutput.writeContent("\r\n            </form>\r\n          </div>\r\n          ");
		jteOutput.writeContent("\r\n        </div>\r\n      </div>\r\n    </div>\r\n  </section>\r\n  ");
		jteOutput.writeContent("\r\n</div>\r\n");
		jteOutput.writeContent("\r\n\r\n<script src=\"/js/cuadro/actualizar.js\"></script>\r\n\r\n");
		gg.jte.generated.ondemand.tag.JtefooterGenerated.render(jteOutput, jteHtmlInterceptor);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		edu.unam.jte.paginas.ModeloCuadro modelo = (edu.unam.jte.paginas.ModeloCuadro)params.get("modelo");
		render(jteOutput, jteHtmlInterceptor, modelo);
	}
}
