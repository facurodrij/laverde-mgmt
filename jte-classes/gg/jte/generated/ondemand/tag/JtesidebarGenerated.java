package gg.jte.generated.ondemand.tag;
public final class JtesidebarGenerated {
	public static final String JTE_NAME = "tag/sidebar.jte";
	public static final int[] JTE_LINE_INFO = {0,0,0,0,0,3,5,15,18,32,34,35};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor) {
		jteOutput.writeContent("\r\n  <aside class=\"main-sidebar sidebar-dark-primary elevation-4\">\r\n\r\n    ");
		jteOutput.writeContent("\r\n    <div class=\"sidebar\">\r\n      ");
		jteOutput.writeContent("\r\n      <div class=\"user-panel mt-3 pb-3 mb-3 d-flex\">\r\n        <div class=\"image\">\r\n          <img src=\"/img/user2-160x160.jpg\" class=\"img-circle elevation-2\" alt=\"User Image\">\r\n        </div>\r\n        <div class=\"info\">\r\n          <a href=\"#\" class=\"d-block\">Alexander Pierce</a>\r\n        </div>\r\n      </div>\r\n\r\n      ");
		jteOutput.writeContent("\r\n      <nav class=\"mt-2\">\r\n        <ul class=\"nav nav-pills nav-sidebar flex-column\" data-widget=\"treeview\" role=\"menu\" data-accordion=\"false\">\r\n          ");
		jteOutput.writeContent("\r\n          <li class=\"nav-header\">EXAMPLES</li>\r\n          <li class=\"nav-item\">\r\n            <a href=\"../calendar.html\" class=\"nav-link\">\r\n              <i class=\"nav-icon far fa-calendar-alt\"></i>\r\n              <p>\r\n                Calendar\r\n                <span class=\"badge badge-info right\">2</span>\r\n              </p>\r\n            </a>\r\n          </li>\r\n        </ul>\r\n      </nav>\r\n      ");
		jteOutput.writeContent("\r\n    </div>\r\n    ");
		jteOutput.writeContent("\r\n  </aside>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		render(jteOutput, jteHtmlInterceptor);
	}
}
