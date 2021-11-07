package gg.jte.generated.ondemand;
public final class JteindexGenerated {
	public static final String JTE_NAME = "index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,0,0,2,2,2,4,4,5,5,5,17,17,25,25,28,28,29};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, edu.unam.jte.paginas.ModeloIndex modelo) {
		jteOutput.writeContent("\r\n");
		gg.jte.generated.ondemand.tag.JteheaderGenerated.render(jteOutput, jteHtmlInterceptor);
		jteOutput.writeContent("\r\n\r\n");
		if (!modelo.nombreUsuario.trim().isEmpty()) {
			jteOutput.writeContent(" \r\n    <h2><b> Hola ");
			jteOutput.setContext("b", null);
			jteOutput.writeUserContent(modelo.nombreUsuario);
			jteOutput.writeContent("! </b></h2>\r\n    <nav class=\"navbar navbar-dark navbar-expand-sm bg-primary\">\r\n\r\n        <ul class=\"navbar-nav\">\r\n            <li class=\"nav-item\">\r\n                <a class=\"navbar-brand\" href=\"/productores\"> Ver productores </a>\r\n            </li>\r\n            <li class=\"nav-item\">\r\n                <a class=\"navbar-brand\" href=\"/productores/nuevo\"> Agregar productor </a>\r\n            </li>\r\n        </ul>\r\n    </nav>\r\n");
		} else {
			jteOutput.writeContent("        \r\n    <form action=\"/\" method=\"post\" onsubmit=\"return validarUsuario();\">\r\n        <div class=\"form-group row\">\r\n            <label class=\"col-sm-2 col-form-label\"> Usuario </label>\r\n            <input class=\"form-control col-sm-4\" type=\"text\" placeholder=\"nombre del usuario\" id=\"nombreUsuario\" name=\"nombreUsuario\"/>\r\n        </div>\r\n        <button class=\"btn btn-primary\"> Ingresar </button>\r\n    </form>\r\n");
		}
		jteOutput.writeContent("\r\n\r\n<script src=\"/js/validarUsuario.js\"></script>\r\n");
		gg.jte.generated.ondemand.tag.JtefooterGenerated.render(jteOutput, jteHtmlInterceptor);
		jteOutput.writeContent("\r\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		edu.unam.jte.paginas.ModeloIndex modelo = (edu.unam.jte.paginas.ModeloIndex)params.get("modelo");
		render(jteOutput, jteHtmlInterceptor, modelo);
	}
}
