package gg.jte.generated.ondemand;
public final class JtecrearProductorGenerated {
	public static final String JTE_NAME = "crearProductor.jte";
	public static final int[] JTE_LINE_INFO = {0,0,0,0,0,0,26,26};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor) {
		gg.jte.generated.ondemand.tag.JteheaderGenerated.render(jteOutput, jteHtmlInterceptor);
		jteOutput.writeContent("\r\n\r\n<h2> Crear productor </h2>\r\n<form action=\"/productores\" method=\"post\">\r\n    <div class=\"form-group row\">\r\n        <label for=\"cuit\" class=\"col-sm-2 col-form-label\"> CUIT del productor </label>\r\n        <div class=\"col-sm-8\">\r\n            <input class=\"form-control\" type=\"text\" placeholder=\"Ingrese el cuit\" name=\"cuit\"/>\r\n        </div>\r\n    </div>\r\n    <div class=\"form-group row\">\r\n        <label for=\"nombre\" class=\"col-sm-2 col-form-label\"> Nombre del productor </label>\r\n        <div class=\"col-sm-8\">\r\n            <input class=\"form-control\" type=\"text\" placeholder=\"Ingrese el nombre\" name=\"nombres\"/>\r\n        </div>\r\n    </div>\r\n    <div class=\"form-group row\">\r\n        <label for=\"apellido\" class=\"col-sm-2 col-form-label\"> Apellido del productor </label>\r\n        <div class=\"col-sm-8\">\r\n            <input class=\"form-control\" type=\"text\" placeholder=\"Ingrese el apellido\" name=\"apellidos\"/>\r\n        </div>\r\n    </div>\r\n    <button type=\"submit\" class=\"btn btn-primary\"> Guardar </button>\r\n    <a href=\"/\" type=\"button\" class=\"btn btn-secondary\"> Volver </a>\r\n</form>\r\n\r\n");
		gg.jte.generated.ondemand.tag.JtefooterGenerated.render(jteOutput, jteHtmlInterceptor);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		render(jteOutput, jteHtmlInterceptor);
	}
}
