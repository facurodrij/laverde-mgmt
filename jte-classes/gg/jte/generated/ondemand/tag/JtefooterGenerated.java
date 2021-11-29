package gg.jte.generated.ondemand.tag;
public final class JtefooterGenerated {
	public static final String JTE_NAME = "tag/footer.jte";
	public static final int[] JTE_LINE_INFO = {7,7,7,7,7,7,9,11,13,29};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor) {
		jteOutput.writeContent("<footer class=\"main-footer\">\r\n    <div class=\"float-right d-none d-sm-block\">\r\n        <b>Version</b> 1.0\r\n    </div>\r\n    <strong>Copyright &copy; 2021 <a href=\"/\">LaVerdeSA</a>.</strong> All rights reserved.\r\n</footer>\r\n</div>\r\n");
		jteOutput.writeContent("\r\n\r\n");
		jteOutput.writeContent("\r\n<script src=\"/plugins/bootstrap/js/bootstrap.bundle.min.js\"></script>\r\n");
		jteOutput.writeContent("\r\n<script src=\"/plugins/adminlte/js/adminlte.min.js\"></script>\r\n");
		jteOutput.writeContent("\r\n<script src=\"//cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js\"></script>\r\n<script src=\"//cdn.datatables.net/1.11.3/js/dataTables.bootstrap4.min.js\"></script>\r\n<script type=\"application/javascript\">\r\n    $(function () {\r\n        $('#data').DataTable({\r\n            responsive: true,\r\n            autoWidth: false,\r\n            language: {\r\n                \"url\": \"//cdn.datatables.net/plug-ins/1.11.3/i18n/es_es.json\"\r\n            }\r\n        });\r\n    });\r\n</script>\r\n</body>\r\n\r\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		render(jteOutput, jteHtmlInterceptor);
	}
}
