package gg.jte.generated.ondemand;
public final class JteindexGenerated {
	public static final String JTE_NAME = "index.jte";
	public static final int[] JTE_LINE_INFO = {1,1,1,1,1,1,1,3,3,5,7,22,25,30,47,51,53,58,60,62,62};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor) {
		jteOutput.writeContent("\r\n");
		gg.jte.generated.ondemand.tag.JteheadGenerated.render(jteOutput, jteHtmlInterceptor);
		jteOutput.writeContent("\r\n\r\n  ");
		gg.jte.generated.ondemand.tag.JtesidebarGenerated.render(jteOutput, jteHtmlInterceptor);
		jteOutput.writeContent("\r\n\r\n  ");
		jteOutput.writeContent("\r\n  <div class=\"content-wrapper\">\r\n    ");
		jteOutput.writeContent("\r\n    <section class=\"content-header\">\r\n      <div class=\"container-fluid\">\r\n        <div class=\"row mb-2\">\r\n          <div class=\"col-sm-6\">\r\n            <h1>Collapsed Sidebar</h1>\r\n          </div>\r\n          <div class=\"col-sm-6\">\r\n            <ol class=\"breadcrumb float-sm-right\">\r\n              <li class=\"breadcrumb-item\"><a href=\"#\">Home</a></li>\r\n              <li class=\"breadcrumb-item\"><a href=\"#\">Layout</a></li>\r\n              <li class=\"breadcrumb-item active\">Collapsed Sidebar</li>\r\n            </ol>\r\n          </div>\r\n        </div>\r\n      </div>");
		jteOutput.writeContent("\r\n    </section>\r\n\r\n    ");
		jteOutput.writeContent("\r\n    <section class=\"content\">\r\n      <div class=\"container-fluid\">\r\n        <div class=\"row\">\r\n          <div class=\"col-12\">\r\n            ");
		jteOutput.writeContent("\r\n            <div class=\"card\">\r\n              <div class=\"card-header\">\r\n                <h3 class=\"card-title\">Title</h3>\r\n\r\n                <div class=\"card-tools\">\r\n                  <button type=\"button\" class=\"btn btn-tool\" data-card-widget=\"collapse\" title=\"Collapse\">\r\n                    <i class=\"fas fa-minus\"></i>\r\n                  </button>\r\n                  <button type=\"button\" class=\"btn btn-tool\" data-card-widget=\"remove\" title=\"Remove\">\r\n                    <i class=\"fas fa-times\"></i>\r\n                  </button>\r\n                </div>\r\n              </div>\r\n              <div class=\"card-body\">\r\n                Start creating your amazing application!\r\n              </div>\r\n              ");
		jteOutput.writeContent("\r\n              <div class=\"card-footer\">\r\n                Footer\r\n              </div>\r\n              ");
		jteOutput.writeContent("\r\n            </div>\r\n            ");
		jteOutput.writeContent("\r\n          </div>\r\n        </div>\r\n      </div>\r\n    </section>\r\n    ");
		jteOutput.writeContent("\r\n  </div>\r\n  ");
		jteOutput.writeContent("\r\n\r\n");
		gg.jte.generated.ondemand.tag.JtefooterGenerated.render(jteOutput, jteHtmlInterceptor);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		render(jteOutput, jteHtmlInterceptor);
	}
}
