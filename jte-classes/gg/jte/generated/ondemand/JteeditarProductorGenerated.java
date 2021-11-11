package gg.jte.generated.ondemand;
public final class JteeditarProductorGenerated {
	public static final String JTE_NAME = "editarProductor.jte";
	public static final int[] JTE_LINE_INFO = {0,0,0,0,2,2,2,4,4,4,6,6,6,10,10,10,10,10,10,10,16,16,16,16,16,16,16,22,22,22,22,22,22,22,31,31};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, edu.unam.jte.paginas.ModeloProductor modelo) {
		jteOutput.writeContent("\r\n");
		gg.jte.generated.ondemand.tag.JteheaderGenerated.render(jteOutput, jteHtmlInterceptor);
		jteOutput.writeContent("\r\n\r\n<h2> Hello ");
		jteOutput.setContext("h2", null);
		jteOutput.writeUserContent(modelo.productor.getNombres());
		jteOutput.writeContent(" </h2>\r\n\r\n<form action=\"/productores/");
		jteOutput.setContext("form", "action");
		jteOutput.writeUserContent(modelo.productor.getIdProductor());
		jteOutput.writeContent("\" method=\"post\">\r\n    <div class=\"form-group row\">\r\n        <label for=\"cuit\" class=\"col-sm-2 col-form-label\"> CUIT del productor </label>\r\n        <div class=\"col-sm-8\">\r\n            <input class=\"form-control\" type=\"text\" placeholder=\"Ingrese el cuit\" name=\"cuit\"");
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(modelo.productor.getCuit())) {
			jteOutput.writeContent(" value=\"");
			jteOutput.setContext("input", "value");
			jteOutput.writeUserContent(modelo.productor.getCuit());
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent("/>\r\n        </div>\r\n    </div>\r\n    <div class=\"form-group row\">\r\n        <label for=\"nombre\" class=\"col-sm-2 col-form-label\"> Nombre del productor </label>\r\n        <div class=\"col-sm-8\">\r\n            <input class=\"form-control\" type=\"text\" placeholder=\"Ingrese el nombre\" name=\"nombres\"");
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(modelo.productor.getNombres())) {
			jteOutput.writeContent(" value=\"");
			jteOutput.setContext("input", "value");
			jteOutput.writeUserContent(modelo.productor.getNombres());
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent("/>\r\n        </div>\r\n    </div>\r\n    <div class=\"form-group row\">\r\n        <label for=\"apellido\" class=\"col-sm-2 col-form-label\"> Apellido del productor </label>\r\n        <div class=\"col-sm-8\">\r\n            <input class=\"form-control\" type=\"text\" placeholder=\"Ingrese el apellido\" name=\"apellidos\"");
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(modelo.productor.getApellidos())) {
			jteOutput.writeContent(" value=\"");
			jteOutput.setContext("input", "value");
			jteOutput.writeUserContent(modelo.productor.getApellidos());
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent("/>\r\n        </div>\r\n    </div>\r\n    <button type=\"submit\" class=\"btn btn-primary\"> Guardar </button>\r\n    <a href=\"/\" type=\"button\" class=\"btn btn-secondary\"> Volver </a>\r\n</form>\r\n\r\n<script src=\"/js/productores.js\"></script>\r\n\r\n");
		gg.jte.generated.ondemand.tag.JtefooterGenerated.render(jteOutput, jteHtmlInterceptor);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		edu.unam.jte.paginas.ModeloProductor modelo = (edu.unam.jte.paginas.ModeloProductor)params.get("modelo");
		render(jteOutput, jteHtmlInterceptor, modelo);
	}
}
