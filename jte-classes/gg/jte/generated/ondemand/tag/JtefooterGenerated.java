package gg.jte.generated.ondemand.tag;
public final class JtefooterGenerated {
	public static final String JTE_NAME = "tag/footer.jte";
	public static final int[] JTE_LINE_INFO = {9,9,9,9,9,9,11,13,15,31};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor) {
		jteOutput.writeContent("<script src=\"/js/cerrarSesion.js\"></script>\n\n<footer class=\"main-footer\">\n    <div class=\"float-right d-none d-sm-block\">\n        <b>Version</b> 1.0\n    </div>\n    <strong>Copyright &copy; 2021 <a href=\"/\">LaVerdeSA</a>.</strong> Todos los derechos reservados.\n</footer>\n</div>\n");
		jteOutput.writeContent("\n\n");
		jteOutput.writeContent("\n<script src=\"/plugins/bootstrap/js/bootstrap.bundle.min.js\"></script>\n");
		jteOutput.writeContent("\n<script src=\"/plugins/adminlte/js/adminlte.min.js\"></script>\n");
		jteOutput.writeContent("\n<script src=\"//cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js\"></script>\n<script src=\"//cdn.datatables.net/1.11.3/js/dataTables.bootstrap4.min.js\"></script>\n<script type=\"application/javascript\">\n    $(function () {\n        $('#data').DataTable({\n            responsive: true,\n            autoWidth: false,\n            language: {\n                \"url\": \"//cdn.datatables.net/plug-ins/1.11.3/i18n/es_es.json\"\n            }\n        });\n    });\n</script>\n</body>\n\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		render(jteOutput, jteHtmlInterceptor);
	}
}
