package gg.jte.generated.ondemand.admin.cuadro;
public final class JteeditarGenerated {
	public static final String JTE_NAME = "admin/cuadro/editar.jte";
	public static final int[] JTE_LINE_INFO = {0,0,0,0,2,2,2,4,4,6,8,16,16,18,18,18,23,23,24,27,32,37,37,37,38,38,38,38,38,38,38,46,46,47,47,48,48,48,48,48,48,48,48,48,48,49,49,50,50,50,50,50,50,50,50,50,50,51,51,52,52,62,62,62,62,62,62,62,72,72,72,72,72,72,72,73,73,73,73,73,73,73,75,75,76,76,78,78,78,78,78,78,78,79,79,79,79,79,79,79,81,81,83,83,83,83,83,83,83,84,84,84,84,84,84,84,86,86,87,87,88,88,88,88,88,88,88,90,90,90,90,90,90,90,93,93,93,93,93,93,93,97,97,97,102,102,103,103,104,104,106,106,106,106,106,106,106,107,107,107,107,107,107,107,109,109,110,110,111,111,111,111,111,111,111,113,113,113,113,113,113,113,116,116,116,116,116,116,116,120,120,120,125,125,126,126,133,138,141,146,148,153,153};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, edu.unam.jte.paginas.ModeloCuadro modelo) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.tag.JteadminheadGenerated.render(jteOutput, jteHtmlInterceptor);
		jteOutput.writeContent("\n\n");
		gg.jte.generated.ondemand.tag.JteadminsidebarGenerated.render(jteOutput, jteHtmlInterceptor);
		jteOutput.writeContent("\n\n");
		jteOutput.writeContent("\n<div class=\"content-wrapper\">\n  ");
		jteOutput.writeContent("\n  <section class=\"content-header\">\n    <div class=\"container-fluid\">\n      <div class=\"row mb-2\">\n        <div class=\"col-sm-6\">\n          <h1>Cuadros</h1>\n        </div>\n      </div>\n      ");
		if (modelo.excepcion != null) {
			jteOutput.writeContent("\n        <div class=\"alert alert-danger alert-dismissible fade show\" role=\"alert\">\n          ");
			jteOutput.setContext("div", null);
			jteOutput.writeUserContent(modelo.excepcion);
			jteOutput.writeContent("\t\n          <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\">\n            <span aria-hidden=\"true\">&times;</span>\n          </button>\n        </div>\n      ");
		}
		jteOutput.writeContent("\n    </div>");
		jteOutput.writeContent("\n  </section>\n\n  ");
		jteOutput.writeContent("\n  <section class=\"content\">\n    <div class=\"container-fluid\">\n      <div class=\"row\">\n        <div class=\"col-12\">\n          ");
		jteOutput.writeContent("\n          <div class=\"card\">\n            <div class=\"card-header\">\n              <h3 class=\"card-title\">Editar Cuadro</h3>\n            </div>\n            <form action=\"/admin/cuadros/");
		jteOutput.setContext("form", "action");
		jteOutput.writeUserContent(modelo.cuadro.getIdCuadro());
		jteOutput.writeContent("\" method=\"post\" id=\"cuadro\">\n              <input class=\"form-control\" type=\"hidden\" id=\"idCuadro\"");
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(modelo.cuadro.getIdCuadro())) {
			jteOutput.writeContent(" value=\"");
			jteOutput.setContext("input", "value");
			jteOutput.writeUserContent(modelo.cuadro.getIdCuadro());
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(" />\n              <div class=\"card-body\">\n                <div class=\"form-group row\">\n                  <div class=\"col-9 input-group\">\n                    <div class=\"input-group-prepend\">\n                      <span class=\"input-group-text\">Lote</span>\n                    </div>\n                    <select class=\"form-control\" id=\"lote\" required>\n                      ");
		for (var lote : modelo.lotes) {
			jteOutput.writeContent("\n                        ");
			if (lote.getIdLote() == modelo.cuadro.getLote().getIdLote()) {
				jteOutput.writeContent("\n                          <option");
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(lote.getIdLote())) {
					jteOutput.writeContent(" value=\"");
					jteOutput.setContext("option", "value");
					jteOutput.writeUserContent(lote.getIdLote());
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" selected>");
				jteOutput.setContext("option", null);
				jteOutput.writeUserContent(lote.toString());
				jteOutput.writeContent("</option>\n                        ");
			} else {
				jteOutput.writeContent("\n                          <option");
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(lote.getIdLote())) {
					jteOutput.writeContent(" value=\"");
					jteOutput.setContext("option", "value");
					jteOutput.writeUserContent(lote.getIdLote());
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(">");
				jteOutput.setContext("option", null);
				jteOutput.writeUserContent(lote.toString());
				jteOutput.writeContent("</option>\n                        ");
			}
			jteOutput.writeContent("\n                      ");
		}
		jteOutput.writeContent("\n                    </select>\n                  </div>\n                </div>\n                <div class=\"form-group row\">\n                  <div class=\"col-9 input-group\">\n                    <div class=\"input-group-prepend\">\n                      <span class=\"input-group-text\">Descripcion</span>\n                    </div>\n                    <input class=\"form-control\" type=\"textarea\" placeholder=\"Ingrese la descripcion\" id=\"descripcion\"");
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(modelo.cuadro.getDescripcion())) {
			jteOutput.writeContent(" value=\"");
			jteOutput.setContext("input", "value");
			jteOutput.writeUserContent(modelo.cuadro.getDescripcion());
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(" required />\n                  </div>\n                </div>\n                <div class=\"form-group row\" id=\"puntos\">\n                  <div class=\"input-group\">\n                    <div class=\"d-block col-10 input-group-prepend center\">\n                      <span class=\"input-group-text\">Puntos:</span>\n                    </div>\n                  </div>\n                  <div class=\"col-10 input-group\">\n                    <input class=\"form-control\" type=\"number\" step=\"0.0000001\" placeholder=\"Ingrese la longitud\" id=\"puntoX\"");
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(modelo.cuadro.getPuntoN(0).getLon())) {
			jteOutput.writeContent(" value=\"");
			jteOutput.setContext("input", "value");
			jteOutput.writeUserContent(modelo.cuadro.getPuntoN(0).getLon());
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(" required />\n                    <input class=\"form-control\" type=\"number\" step=\"0.0000001\" placeholder=\"Ingrese la latitud\" id=\"puntoY\"");
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(modelo.cuadro.getPuntoN(0).getLat())) {
			jteOutput.writeContent(" value=\"");
			jteOutput.setContext("input", "value");
			jteOutput.writeUserContent(modelo.cuadro.getPuntoN(0).getLat());
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(" required />\n                  </div>\n                  ");
		if (modelo.cuadro.getCantidadPuntos()==5) {
			jteOutput.writeContent("\n                    ");
			if (modelo.cuadro.getPuntoN(0).getLon()==modelo.cuadro.getPuntoN(3).getLon() && modelo.cuadro.getPuntoN(1).getLon()==modelo.cuadro.getPuntoN(2).getLon() && modelo.cuadro.getPuntoN(0).getLat()==modelo.cuadro.getPuntoN(1).getLat() && modelo.cuadro.getPuntoN(2).getLat()==modelo.cuadro.getPuntoN(3).getLat()) {
				jteOutput.writeContent("\n                      <div class=\"col-10 input-group\">\n                        <input class=\"form-control\" type=\"number\" step=\"0.0000001\" placeholder=\"Ingrese la longitud\" id=\"puntoX\"");
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(modelo.cuadro.getPuntoN(2).getLon())) {
					jteOutput.writeContent(" value=\"");
					jteOutput.setContext("input", "value");
					jteOutput.writeUserContent(modelo.cuadro.getPuntoN(2).getLon());
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" required />\n                        <input class=\"form-control\" type=\"number\" step=\"0.0000001\" placeholder=\"Ingrese la latitud\" id=\"puntoY\"");
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(modelo.cuadro.getPuntoN(2).getLat())) {
					jteOutput.writeContent(" value=\"");
					jteOutput.setContext("input", "value");
					jteOutput.writeUserContent(modelo.cuadro.getPuntoN(2).getLat());
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" required />\n                      </div>\n                    ");
			} else {
				jteOutput.writeContent("\n                      <div class=\"col-10 input-group\">\n                        <input class=\"form-control\" type=\"number\" step=\"0.0000001\" placeholder=\"Ingrese la longitud\" id=\"puntoX\"");
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(modelo.cuadro.getPuntoN(1).getLon())) {
					jteOutput.writeContent(" value=\"");
					jteOutput.setContext("input", "value");
					jteOutput.writeUserContent(modelo.cuadro.getPuntoN(1).getLon());
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" required />\n                        <input class=\"form-control\" type=\"number\" step=\"0.0000001\" placeholder=\"Ingrese la latitud\" id=\"puntoY\"");
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(modelo.cuadro.getPuntoN(1).getLat())) {
					jteOutput.writeContent(" value=\"");
					jteOutput.setContext("input", "value");
					jteOutput.writeUserContent(modelo.cuadro.getPuntoN(1).getLat());
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" required />\n                      </div>\n                      ");
				for (int i=2; i<(modelo.cuadro.getCantidadPuntos()-1); ++i) {
					jteOutput.writeContent("\n                        ");
					var nombreDiv = String.valueOf(i);;
					jteOutput.writeContent("\n                        <div");
					if (gg.jte.runtime.TemplateUtils.isAttributeRendered(nombreDiv)) {
						jteOutput.writeContent(" id=\"");
						jteOutput.setContext("div", "id");
						jteOutput.writeUserContent(nombreDiv);
						jteOutput.writeContent("\"");
					}
					jteOutput.writeContent(" class=\"input-group align-items-center\">\n                          <div class=\"col-sm-5\" style=\"padding-right:0px;\">\n                            <input class=\"form-control\" type=\"number\" step=\"0.0000001\" placeholder=\"Ingrese la longitud\" id=\"puntoX\"");
					if (gg.jte.runtime.TemplateUtils.isAttributeRendered(modelo.cuadro.getPuntoN(i).getLon())) {
						jteOutput.writeContent(" value=\"");
						jteOutput.setContext("input", "value");
						jteOutput.writeUserContent(modelo.cuadro.getPuntoN(i).getLon());
						jteOutput.writeContent("\"");
					}
					jteOutput.writeContent(" required />\n                          </div>\n                          <div class=\"col-sm-5\" style=\"padding-left:0px;\">\n                            <input class=\"form-control\" type=\"number\" step=\"0.0000001\" placeholder=\"Ingrese la latitud\" id=\"puntoY\"");
					if (gg.jte.runtime.TemplateUtils.isAttributeRendered(modelo.cuadro.getPuntoN(i).getLat())) {
						jteOutput.writeContent(" value=\"");
						jteOutput.setContext("input", "value");
						jteOutput.writeUserContent(modelo.cuadro.getPuntoN(i).getLat());
						jteOutput.writeContent("\"");
					}
					jteOutput.writeContent(" required />\n                          </div>\n                          <div class=\"input-group-append\">\n                            <a id=\"eliminador\" type=\"button\" class=\"btn btn-danger btn-sm\"\n                              onClick=\"document.getElementById(&quot;");
					jteOutput.setContext("a", "onClick");
					jteOutput.writeUserContent(nombreDiv);
					jteOutput.writeContent("&quot;).remove()\">\n                              <i class=\"fas fa-trash-alt\"></i>\n                            </a>\n                          </div>\n                        </div>\n                      ");
				}
				jteOutput.writeContent("\n                    ");
			}
			jteOutput.writeContent("\n                  ");
		} else {
			jteOutput.writeContent("\n                    <div class=\"col-10 input-group\">\n                      <input class=\"form-control\" type=\"number\" step=\"0.001\" placeholder=\"Ingrese la longitud\" id=\"puntoX\"");
			if (gg.jte.runtime.TemplateUtils.isAttributeRendered(modelo.cuadro.getPuntoN(1).getLon())) {
				jteOutput.writeContent(" value=\"");
				jteOutput.setContext("input", "value");
				jteOutput.writeUserContent(modelo.cuadro.getPuntoN(1).getLon());
				jteOutput.writeContent("\"");
			}
			jteOutput.writeContent(" required />\n                      <input class=\"form-control\" type=\"number\" step=\"0.001\" placeholder=\"Ingrese la latitud\" id=\"puntoY\"");
			if (gg.jte.runtime.TemplateUtils.isAttributeRendered(modelo.cuadro.getPuntoN(1).getLat())) {
				jteOutput.writeContent(" value=\"");
				jteOutput.setContext("input", "value");
				jteOutput.writeUserContent(modelo.cuadro.getPuntoN(1).getLat());
				jteOutput.writeContent("\"");
			}
			jteOutput.writeContent(" required />\n                    </div>\n                    ");
			for (int i=2; i<(modelo.cuadro.getCantidadPuntos()-1); ++i) {
				jteOutput.writeContent("\n                      ");
				var nombreDiv = String.valueOf(i);;
				jteOutput.writeContent("\n                      <div");
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(nombreDiv)) {
					jteOutput.writeContent(" id=\"");
					jteOutput.setContext("div", "id");
					jteOutput.writeUserContent(nombreDiv);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" class=\"input-group align-items-center\">\n                        <div class=\"col-sm-5\" style=\"padding-right:0px;\">\n                          <input class=\"form-control\" type=\"number\" step=\"0.001\" placeholder=\"Ingrese la longitud\" id=\"puntoX\"");
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(modelo.cuadro.getPuntoN(i).getLon())) {
					jteOutput.writeContent(" value=\"");
					jteOutput.setContext("input", "value");
					jteOutput.writeUserContent(modelo.cuadro.getPuntoN(i).getLon());
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" required />\n                        </div>\n                        <div class=\"col-sm-5\" style=\"padding-left:0px;\">\n                          <input class=\"form-control\" type=\"number\" step=\"0.001\" placeholder=\"Ingrese la latitud\" id=\"puntoY\"");
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(modelo.cuadro.getPuntoN(i).getLat())) {
					jteOutput.writeContent(" value=\"");
					jteOutput.setContext("input", "value");
					jteOutput.writeUserContent(modelo.cuadro.getPuntoN(i).getLat());
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" required />\n                        </div>\n                        <div class=\"input-group-append\">\n                          <a id=\"eliminador\" type=\"button\" class=\"btn btn-danger btn-sm\"\n                            onClick=\"document.getElementById(&quot;");
				jteOutput.setContext("a", "onClick");
				jteOutput.writeUserContent(nombreDiv);
				jteOutput.writeContent("&quot;).remove()\">\n                            <i class=\"fas fa-trash-alt\"></i>\n                          </a>\n                        </div>\n                      </div>\n                    ");
			}
			jteOutput.writeContent("\n                  ");
		}
		jteOutput.writeContent("\n                  <div class=\"col-10 input-group\" style=\"margin-top:20px;\" id=\"boton\">\n                    <button type=\"button\" class=\"btn btn-outline-primary float-left\"\n                      id=\"agregador\" onClick=\"agregar()\"> Agregar </button>\n                  </div>\n                </div>\n              </div>\n              ");
		jteOutput.writeContent("\n              <div class=\"card-footer\">\n                <button type=\"submit\" class=\"btn btn-primary\"><i class=\"fas fa-save\"></i> Guardar</button>\n                <a href=\".\" type=\"button\" class=\"btn btn-secondary\"> Volver </a>\n              </div>\n              ");
		jteOutput.writeContent("\n            </form>\n          </div>\n          ");
		jteOutput.writeContent("\n        </div>\n      </div>\n    </div>\n  </section>\n  ");
		jteOutput.writeContent("\n</div>\n");
		jteOutput.writeContent("\n\n<script src=\"/js/cuadro/actualizar.js\"></script>\n<script src=\"/js/cuadro/puntos.js\"></script>\n\n");
		gg.jte.generated.ondemand.tag.JtefooterGenerated.render(jteOutput, jteHtmlInterceptor);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		edu.unam.jte.paginas.ModeloCuadro modelo = (edu.unam.jte.paginas.ModeloCuadro)params.get("modelo");
		render(jteOutput, jteHtmlInterceptor, modelo);
	}
}
