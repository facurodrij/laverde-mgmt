package gg.jte.generated.ondemand.tag;
public final class JtefooterGenerated {
	public static final String JTE_NAME = "tag/footer.jte";
	public static final int[] JTE_LINE_INFO = {7,7,7,7,7,7,9,11,13,15,19};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor) {
		jteOutput.writeContent("            <footer class=\"main-footer\">\r\n                <div class=\"float-right d-none d-sm-block\">\r\n                <b>Version</b> 3.1.0\r\n                </div>\r\n                <strong>Copyright &copy; 2014-2021 <a href=\"https://adminlte.io\">AdminLTE.io</a>.</strong> All rights reserved.\r\n            </footer>\r\n        </div>\r\n        ");
		jteOutput.writeContent("\r\n\r\n        ");
		jteOutput.writeContent("\r\n        <script src=\"/plugins/adminlte/js/jquery.min.js\"></script>\r\n        ");
		jteOutput.writeContent("\r\n        <script src=\"/plugins/bootstrap/js/bootstrap.bundle.min.js\"></script>\r\n        ");
		jteOutput.writeContent("\r\n        <script src=\"/plugins/adminlte/js/adminlte.min.js\"></script>\r\n        ");
		jteOutput.writeContent("\r\n        <script src=\"/plugins/adminlte/js/demo.js\"></script>\r\n    </body>\r\n</html>\r\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		render(jteOutput, jteHtmlInterceptor);
	}
}
