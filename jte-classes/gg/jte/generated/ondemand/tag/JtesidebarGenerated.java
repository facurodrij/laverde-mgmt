package gg.jte.generated.ondemand.tag;
public final class JtesidebarGenerated {
	public static final String JTE_NAME = "tag/sidebar.jte";
	public static final int[] JTE_LINE_INFO = {0,0,0,0,0,2,8,10,63,65,66};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor) {
		jteOutput.writeContent("\r\n<aside class=\"main-sidebar sidebar-dark-primary elevation-4\">\r\n  ");
		jteOutput.writeContent("\r\n  <a href=\"#\" class=\"brand-link\">\r\n    <img src=\"/img/logo.png\" alt=\"LaVerdeSA Logo\" class=\"brand-image img-circle elevation-3\" style=\"opacity: .8\">\r\n    <span class=\"brand-text font-weight-light\">LaVerdeSA</span>\r\n  </a>\r\n\r\n  ");
		jteOutput.writeContent("\r\n  <div class=\"sidebar\">\r\n    ");
		jteOutput.writeContent("\r\n    <nav class=\"mt-2\">\r\n      <ul class=\"nav nav-pills nav-sidebar flex-column\" data-widget=\"treeview\" role=\"menu\" data-accordion=\"false\">\r\n        <li class=\"nav-item\">\r\n          <a href=\"/productores\" class=\"nav-link\">\r\n            <i class=\"nav-icon fas fa-tractor\"></i>\r\n            <p>\r\n              Productores\r\n            </p>\r\n          </a>\r\n        </li>\r\n        <li class=\"nav-item\">\r\n          <a href=\"/lotes\" class=\"nav-link\">\r\n            <i class=\"nav-icon fas fa-border-all\"></i>\r\n            <p>\r\n              Lotes\r\n            </p>\r\n          </a>\r\n        </li>\r\n        <li class=\"nav-item\">\r\n          <a href=\"/cuadros\" class=\"nav-link\">\r\n            <i class=\"nav-icon fab fa-buromobelexperte\"></i>\r\n            <p>\r\n              Cuadros\r\n            </p>\r\n          </a>\r\n        </li>\r\n        <li class=\"nav-item\">\r\n          <a href=\"/empleados\" class=\"nav-link\">\r\n            <i class=\"nav-icon fas fa-id-card\"></i>\r\n            <p>\r\n              Empleados\r\n            </p>\r\n          </a>\r\n        </li>\r\n        <li class=\"nav-item\">\r\n          <a href=\"#\" class=\"nav-link\">\r\n            <i class=\"nav-icon fas fa-warehouse\"></i>\r\n            <p>\r\n              Secaderos\r\n            </p>\r\n          </a>\r\n        </li>\r\n        <li class=\"nav-item\">\r\n          <a href=\"#\" class=\"nav-link\">\r\n            <i class=\"nav-icon fas fa-seedling\"></i>\r\n            <p>\r\n              Cosechas\r\n            </p>\r\n          </a>\r\n        </li>\r\n      </ul>\r\n    </nav>\r\n    ");
		jteOutput.writeContent("\r\n  </div>\r\n  ");
		jteOutput.writeContent("\r\n</aside>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		render(jteOutput, jteHtmlInterceptor);
	}
}
