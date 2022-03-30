package gg.jte.generated.ondemand.tag;
public final class JteadminsidebarGenerated {
	public static final String JTE_NAME = "tag/adminsidebar.jte";
	public static final int[] JTE_LINE_INFO = {0,0,0,0,0,2,8,10,63,65,66};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor) {
		jteOutput.writeContent("\n<aside class=\"main-sidebar sidebar-dark-primary elevation-4\">\n  ");
		jteOutput.writeContent("\n  <a href=\"#\" class=\"brand-link\">\n    <img src=\"/img/logo.png\" alt=\"LaVerdeSA Logo\" class=\"brand-image img-circle elevation-3\" style=\"opacity: .8\">\n    <span class=\"brand-text font-weight-light\">LaVerdeSA</span>\n  </a>\n\n  ");
		jteOutput.writeContent("\n  <div class=\"sidebar\">\n    ");
		jteOutput.writeContent("\n    <nav class=\"mt-2\">\n      <ul class=\"nav nav-pills nav-sidebar flex-column\" data-widget=\"treeview\" role=\"menu\" data-accordion=\"false\">\n        <li class=\"nav-item\">\n          <a href=\"/admin/productores\" class=\"nav-link\">\n            <i class=\"nav-icon fas fa-tractor\"></i>\n            <p>\n              Productores\n            </p>\n          </a>\n        </li>\n        <li class=\"nav-item\">\n          <a href=\"/admin/lotes\" class=\"nav-link\">\n            <i class=\"nav-icon fas fa-border-all\"></i>\n            <p>\n              Lotes\n            </p>\n          </a>\n        </li>\n        <li class=\"nav-item\">\n          <a href=\"/admin/cuadros\" class=\"nav-link\">\n            <i class=\"nav-icon fab fa-buromobelexperte\"></i>\n            <p>\n              Cuadros\n            </p>\n          </a>\n        </li>\n        <li class=\"nav-item\">\n          <a href=\"/admin/empleados\" class=\"nav-link\">\n            <i class=\"nav-icon fas fa-id-card\"></i>\n            <p>\n              Empleados\n            </p>\n          </a>\n        </li>\n        <li class=\"nav-item\">\n          <a href=\"/admin/secaderos\" class=\"nav-link\">\n            <i class=\"nav-icon fas fa-warehouse\"></i>\n            <p>\n              Secaderos\n            </p>\n          </a>\n        </li>\n        <li class=\"nav-item\">\n          <a href=\"/admin/cosechas\" class=\"nav-link\">\n            <i class=\"nav-icon fas fa-seedling\"></i>\n            <p>\n              Cosechas\n            </p>\n          </a>\n        </li>\n      </ul>\n    </nav>\n    ");
		jteOutput.writeContent("\n  </div>\n  ");
		jteOutput.writeContent("\n</aside>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		render(jteOutput, jteHtmlInterceptor);
	}
}
