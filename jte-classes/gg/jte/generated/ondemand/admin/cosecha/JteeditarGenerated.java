package gg.jte.generated.ondemand.admin.cosecha;
public final class JteeditarGenerated {
	public static final String JTE_NAME = "admin/cosecha/editar.jte";
	public static final int[] JTE_LINE_INFO = {0,0,0,0,2,2,2,4,4,6,8,16,16,18,18,18,23,23,24,27,32,37,37,37,38,38,38,38,38,38,38,46,46,47,47,48,48,48,48,48,48,48,48,48,48,49,49,50,50,50,50,50,50,50,50,50,50,51,51,52,52,60,60,61,61,62,62,62,62,62,62,62,62,62,62,63,63,64,64,64,64,64,64,64,64,64,64,65,65,66,66,76,76,77,77,78,78,78,78,78,78,78,78,78,78,79,79,80,80,80,80,80,80,80,80,80,80,81,81,82,82,91,91,91,91,91,91,91,98,98,98,98,98,98,98,106,106,106,106,106,106,106,113,113,113,113,113,113,113,117,122,125,130,132,136,136};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, edu.unam.jte.paginas.ModeloCosecha modelo) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.tag.JteadminheadGenerated.render(jteOutput, jteHtmlInterceptor);
		jteOutput.writeContent("\n\n");
		gg.jte.generated.ondemand.tag.JteadminsidebarGenerated.render(jteOutput, jteHtmlInterceptor);
		jteOutput.writeContent("\n\n");
		jteOutput.writeContent("\n<div class=\"content-wrapper\">\n  ");
		jteOutput.writeContent("\n  <section class=\"content-header\">\n    <div class=\"container-fluid\">\n      <div class=\"row mb-2\">\n        <div class=\"col-sm-6\">\n          <h1>Cosechas</h1>\n        </div>\n      </div>\n      ");
		if (modelo.excepcion != null) {
			jteOutput.writeContent("\n        <div class=\"alert alert-danger alert-dismissible fade show\" role=\"alert\">\n          ");
			jteOutput.setContext("div", null);
			jteOutput.writeUserContent(modelo.excepcion);
			jteOutput.writeContent("\t\n          <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\">\n            <span aria-hidden=\"true\">&times;</span>\n          </button>\n        </div>\n      ");
		}
		jteOutput.writeContent("\n    </div>");
		jteOutput.writeContent("\n  </section>\n\n  ");
		jteOutput.writeContent("\n  <section class=\"content\">\n    <div class=\"container-fluid\">\n      <div class=\"row\">\n        <div class=\"col-12\">\n          ");
		jteOutput.writeContent("\n          <div class=\"card\">\n            <div class=\"card-header\">\n              <h3 class=\"card-title\">Crear Cosecha</h3>\n            </div>\n            <form action=\"/admin/cosechas/");
		jteOutput.setContext("form", "action");
		jteOutput.writeUserContent(modelo.cosecha.getIdCosecha());
		jteOutput.writeContent("\" method=\"post\" id=\"cosecha\">\n              <input class=\"form-control\" type=\"hidden\" id=\"idCosecha\"");
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(modelo.cosecha.getIdCosecha())) {
			jteOutput.writeContent(" value=\"");
			jteOutput.setContext("input", "value");
			jteOutput.writeUserContent(modelo.cosecha.getIdCosecha());
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(" />\n              <div class=\"card-body\">\n                <div class=\"form-group row\">\n                  <div class=\"col-6 input-group\">\n                    <div class=\"input-group-prepend\">\n                      <span class=\"input-group-text\">Empleados</span>\n                    </div>\n                    <select class=\"form-control\" id=\"empleado\" multiple required>\n                      ");
		for (var empleado : modelo.empleados) {
			jteOutput.writeContent("\n                        ");
			if (modelo.cosecha.getEmpleados().contains(empleado)) {
				jteOutput.writeContent("\n                          <option");
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(empleado.getIdEmpleado())) {
					jteOutput.writeContent(" value=\"");
					jteOutput.setContext("option", "value");
					jteOutput.writeUserContent(empleado.getIdEmpleado());
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" selected>");
				jteOutput.setContext("option", null);
				jteOutput.writeUserContent(empleado.toString());
				jteOutput.writeContent("</option>\n                        ");
			} else {
				jteOutput.writeContent("\n                          <option");
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(empleado.getIdEmpleado())) {
					jteOutput.writeContent(" value=\"");
					jteOutput.setContext("option", "value");
					jteOutput.writeUserContent(empleado.getIdEmpleado());
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(">");
				jteOutput.setContext("option", null);
				jteOutput.writeUserContent(empleado.toString());
				jteOutput.writeContent("</option>\n                        ");
			}
			jteOutput.writeContent("\n                      ");
		}
		jteOutput.writeContent("\n                    </select>\n                  </div>\n                  <div class=\"col-6 input-group\">\n                    <div class=\"input-group-prepend\">\n                      <span class=\"input-group-text\">Cuadros</span>\n                    </div>\n                    <select class=\"form-control\" id=\"cuadro\" multiple required>\n                      ");
		for (var cuadro : modelo.cuadros) {
			jteOutput.writeContent("\n                        ");
			if (modelo.cosecha.getCuadros().contains(cuadro)) {
				jteOutput.writeContent("\n                          <option");
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(cuadro.getIdCuadro())) {
					jteOutput.writeContent(" value=\"");
					jteOutput.setContext("option", "value");
					jteOutput.writeUserContent(cuadro.getIdCuadro());
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" selected>");
				jteOutput.setContext("option", null);
				jteOutput.writeUserContent(cuadro.toString());
				jteOutput.writeContent("</option>\n                        ");
			} else {
				jteOutput.writeContent("\n                          <option");
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(cuadro.getIdCuadro())) {
					jteOutput.writeContent(" value=\"");
					jteOutput.setContext("option", "value");
					jteOutput.writeUserContent(cuadro.getIdCuadro());
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(">");
				jteOutput.setContext("option", null);
				jteOutput.writeUserContent(cuadro.toString());
				jteOutput.writeContent("</option>\n                        ");
			}
			jteOutput.writeContent("\n                      ");
		}
		jteOutput.writeContent("\n                    </select>\n                  </div>\n                </div>\n                <div class=\"form-group row\">\n                  <div class=\"col-12 input-group\">\n                    <div class=\"input-group-prepend\">\n                      <span class=\"input-group-text\">Secaderos</span>\n                    </div>\n                    <select class=\"form-control\" id=\"secadero\" required>\n                      ");
		for (var secadero : modelo.secaderos) {
			jteOutput.writeContent("\n                        ");
			if (secadero.getIdSecadero() == modelo.cosecha.getSecadero().getIdSecadero()) {
				jteOutput.writeContent("\n                          <option");
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(secadero.getIdSecadero())) {
					jteOutput.writeContent(" value=\"");
					jteOutput.setContext("option", "value");
					jteOutput.writeUserContent(secadero.getIdSecadero());
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" selected>");
				jteOutput.setContext("option", null);
				jteOutput.writeUserContent(secadero.toString());
				jteOutput.writeContent("</option>\n                        ");
			} else {
				jteOutput.writeContent("\n                          <option");
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(secadero.getIdSecadero())) {
					jteOutput.writeContent(" value=\"");
					jteOutput.setContext("option", "value");
					jteOutput.writeUserContent(secadero.getIdSecadero());
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(">");
				jteOutput.setContext("option", null);
				jteOutput.writeUserContent(secadero.toString());
				jteOutput.writeContent("</option>\n                        ");
			}
			jteOutput.writeContent("\n                      ");
		}
		jteOutput.writeContent("\n                    </select>\n                  </div>\n                </div>\n                <div class=\"form-group row\">\n                  <div class=\"col-6 input-group\">\n                    <div class=\"input-group-prepend\">\n                      <span class=\"input-group-text\">Peso Entrega</span>\n                    </div>\n                    <input class=\"form-control\" type=\"number\" step=\"0.0000001\" placeholder=\"Ingrese el peso de entrega\" id=\"pesoEntrega\"");
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(modelo.cosecha.getPesoEntrega())) {
			jteOutput.writeContent(" value=\"");
			jteOutput.setContext("input", "value");
			jteOutput.writeUserContent(modelo.cosecha.getPesoEntrega());
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(" required />\n                    <small></small>\n                  </div>\n                  <div class=\"col-6 input-group\">\n                    <div class=\"input-group-prepend\">\n                      <span class=\"input-group-text\">Fecha Entrega</span>\n                    </div>\n                    <input class=\"form-control\" type=\"date\" id=\"tiempoEntrega\"");
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(modelo.cosecha.getTiempoEntrega().toString())) {
			jteOutput.writeContent(" value=\"");
			jteOutput.setContext("input", "value");
			jteOutput.writeUserContent(modelo.cosecha.getTiempoEntrega().toString());
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(" required />\n                  </div>\n                </div>\n                <div class=\"form-group row\">\n                  <div class=\"col-6 input-group\">\n                    <div class=\"input-group-prepend\">\n                      <span class=\"input-group-text\">Peso Registro</span>\n                    </div>\n                    <input class=\"form-control\" type=\"number\" step=\"0.0000001\" placeholder=\"Ingrese el peso de registro\" id=\"pesoRegistro\"");
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(modelo.cosecha.getPesoRegistro())) {
			jteOutput.writeContent(" value=\"");
			jteOutput.setContext("input", "value");
			jteOutput.writeUserContent(modelo.cosecha.getPesoRegistro());
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(" required />\n                    <small></small>\n                  </div>\n                  <div class=\"col-6 input-group\">\n                    <div class=\"input-group-prepend\">\n                      <span class=\"input-group-text\">Fecha Registro</span>\n                    </div>\n                    <input class=\"form-control\" type=\"date\" id=\"tiempoRegistro\"");
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(modelo.cosecha.getTiempoRegistro().toString())) {
			jteOutput.writeContent(" value=\"");
			jteOutput.setContext("input", "value");
			jteOutput.writeUserContent(modelo.cosecha.getTiempoRegistro().toString());
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(" required />\n                  </div>\n                </div>\n              </div>\n              ");
		jteOutput.writeContent("\n              <div class=\"card-footer\">\n                <button type=\"submit\" class=\"btn btn-primary\"><i class=\"fas fa-save\"></i> Guardar</button>\n                <a href=\".\" type=\"button\" class=\"btn btn-secondary\"> Volver </a>\n              </div>\n              ");
		jteOutput.writeContent("\n            </form>\n          </div>\n          ");
		jteOutput.writeContent("\n        </div>\n      </div>\n    </div>\n  </section>\n  ");
		jteOutput.writeContent("\n</div>\n");
		jteOutput.writeContent("\n\n<script src=\"/js/cosecha/actualizar.js\"></script>\n\n");
		gg.jte.generated.ondemand.tag.JtefooterGenerated.render(jteOutput, jteHtmlInterceptor);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		edu.unam.jte.paginas.ModeloCosecha modelo = (edu.unam.jte.paginas.ModeloCosecha)params.get("modelo");
		render(jteOutput, jteHtmlInterceptor, modelo);
	}
}
