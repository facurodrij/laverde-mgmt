package gg.jte.generated.ondemand;
public final class JteindexGenerated {
	public static final String JTE_NAME = "index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,0,0,2,2,2,4,4,6,8,16,19,24,39,39,40,40,40,41,41,50,50,52,56,58,63,65,67,67};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, edu.unam.jte.paginas.ModeloIndex modelo) {
		jteOutput.writeContent("\r\n");
		gg.jte.generated.ondemand.tag.JteheadGenerated.render(jteOutput, jteHtmlInterceptor);
		jteOutput.writeContent("\r\n\r\n");
		gg.jte.generated.ondemand.tag.JtesidebarGenerated.render(jteOutput, jteHtmlInterceptor);
		jteOutput.writeContent("\r\n\r\n");
		jteOutput.writeContent("\r\n<div class=\"content-wrapper\">\r\n  ");
		jteOutput.writeContent("\r\n  <section class=\"content-header\">\r\n    <div class=\"container-fluid\">\r\n      <div class=\"row mb-2\">\r\n        <div class=\"col-sm-6\">\r\n          <h1>La Verde</h1>\r\n        </div>\r\n      </div>\r\n    </div>");
		jteOutput.writeContent("\r\n  </section>\r\n\r\n  ");
		jteOutput.writeContent("\r\n  <section class=\"content\">\r\n    <div class=\"container-fluid\">\r\n      <div class=\"row\">\r\n        <div class=\"col-12\">\r\n          ");
		jteOutput.writeContent("\r\n          <div class=\"card\">\r\n            <div class=\"card-header\">\r\n              <h3 class=\"card-title\">Title</h3>\r\n\r\n              <div class=\"card-tools\">\r\n                <button type=\"button\" class=\"btn btn-tool\" data-card-widget=\"collapse\" title=\"Collapse\">\r\n                  <i class=\"fas fa-minus\"></i>\r\n                </button>\r\n                <button type=\"button\" class=\"btn btn-tool\" data-card-widget=\"remove\" title=\"Remove\">\r\n                  <i class=\"fas fa-times\"></i>\r\n                </button>\r\n              </div>\r\n            </div>\r\n            <div class=\"card-body\">\r\n              ");
		if (!modelo.nombreUsuario.trim().isEmpty()) {
			jteOutput.writeContent("\r\n              <h2><b> Hola ");
			jteOutput.setContext("b", null);
			jteOutput.writeUserContent(modelo.nombreUsuario);
			jteOutput.writeContent("! </b></h2>\r\n              ");
		} else {
			jteOutput.writeContent("\r\n              <form action=\"/\" method=\"post\" onsubmit=\"return validarUsuario();\">\r\n                <div class=\"form-group row\">\r\n                  <label class=\"col-sm-2 col-form-label\"> Usuario </label>\r\n                  <input class=\"form-control col-sm-4\" type=\"text\" placeholder=\"nombre del usuario\" id=\"nombreUsuario\"\r\n                    name=\"nombreUsuario\" />\r\n                </div>\r\n                <button class=\"btn btn-primary\"> Ingresar </button>\r\n              </form>\r\n              ");
		}
		jteOutput.writeContent("\r\n            </div>\r\n            ");
		jteOutput.writeContent("\r\n            <div class=\"card-footer\">\r\n              Footer\r\n            </div>\r\n            ");
		jteOutput.writeContent("\r\n          </div>\r\n          ");
		jteOutput.writeContent("\r\n        </div>\r\n      </div>\r\n    </div>\r\n  </section>\r\n  ");
		jteOutput.writeContent("\r\n</div>\r\n");
		jteOutput.writeContent("\r\n\r\n");
		gg.jte.generated.ondemand.tag.JtefooterGenerated.render(jteOutput, jteHtmlInterceptor);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		edu.unam.jte.paginas.ModeloIndex modelo = (edu.unam.jte.paginas.ModeloIndex)params.get("modelo");
		render(jteOutput, jteHtmlInterceptor, modelo);
	}
}
