package gg.jte.generated.ondemand;
import edu.unam.jte.paginas.ModeloProductores;
public final class JteproductoresGenerated {
	public static final String JTE_NAME = "productores.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,3,3,3,21,21,23,23,23,24,24,24,25,25,25,26,26,26,27,27,27,28,28,28,30,30,36,36};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, ModeloProductores modelo) {
		jteOutput.writeContent("\r\n");
		gg.jte.generated.ondemand.tag.JteheaderGenerated.render(jteOutput, jteHtmlInterceptor);
		jteOutput.writeContent("\r\n\r\n<h2> Productores </h2>\r\n<a href=\"/\" type=\"button\" class=\"btn btn-secondary\"> Volver </a>\r\n<div class=\"table-responsive\">\r\n    <table class=\"table table-hover table-striped\">\r\n        <thead>\r\n            <tr>\r\n                <th scope=\"col\">#</th>\r\n                <th scope=\"col\">CUIT</th>\r\n                <th scope=\"col\">Apellidos</th>\r\n                <th scope=\"col\">Nombres</th>\r\n                <th class=\"col-1\" scope=\"col\"> </th>\r\n                <th class=\"col-1\" scope=\"col\"> </th>\r\n            </tr>\r\n        </thead>\r\n\r\n        <tbody>\r\n            ");
		for (var productor : modelo.productores) {
			jteOutput.writeContent("\r\n                <tr>\r\n                    <td scope=\"row\">");
			jteOutput.setContext("td", null);
			jteOutput.writeUserContent(productor.getIdProductor());
			jteOutput.writeContent("</td>\r\n                    <td>");
			jteOutput.setContext("td", null);
			jteOutput.writeUserContent(productor.getCuit());
			jteOutput.writeContent("</td>\r\n                    <td>");
			jteOutput.setContext("td", null);
			jteOutput.writeUserContent(productor.getApellidos());
			jteOutput.writeContent("</td>\r\n                    <td>");
			jteOutput.setContext("td", null);
			jteOutput.writeUserContent(productor.getNombres());
			jteOutput.writeContent("</td>\r\n                    <td class=\"col-1\"> <a type=\"button\" class=\"btn btn-info no-gutters\" href=\"productores/");
			jteOutput.setContext("a", "href");
			jteOutput.writeUserContent(productor.getIdProductor());
			jteOutput.writeContent("\"> Editar </a></td>                            \r\n                    <td class=\"col-1\"> <button type=\"button\" class=\"btn btn-danger no-gutters\" onClick=\"borrar(");
			jteOutput.setContext("button", "onClick");
			jteOutput.writeUserContent(productor.getIdProductor());
			jteOutput.writeContent(")\"> Eliminar </button></td>\r\n                </tr>\r\n            ");
		}
		jteOutput.writeContent("\r\n        </tbody>\r\n    </table>\r\n</div>\r\n<script src=\"/js/productores.js\"></script>\r\n\r\n");
		gg.jte.generated.ondemand.tag.JtefooterGenerated.render(jteOutput, jteHtmlInterceptor);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		ModeloProductores modelo = (ModeloProductores)params.get("modelo");
		render(jteOutput, jteHtmlInterceptor, modelo);
	}
}
