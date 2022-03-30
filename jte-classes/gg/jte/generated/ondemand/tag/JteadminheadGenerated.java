package gg.jte.generated.ondemand.tag;
public final class JteadminheadGenerated {
	public static final String JTE_NAME = "tag/adminhead.jte";
	public static final int[] JTE_LINE_INFO = {8,8,8,8,8,8,11,13,15,18,24,26,28,51};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor) {
		jteOutput.writeContent("<!DOCTYPE html>\n<html lang=\"en\">\n\n<head>\n  <meta charset=\"utf-8\">\n  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n  <title>LaVerdeSA</title>\n\n  ");
		jteOutput.writeContent("\n  <link rel=\"stylesheet\"\n    href=\"https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback\">\n  ");
		jteOutput.writeContent("\n  <link rel=\"stylesheet\" href=\"/plugins/fontawesome-free/css/all.min.css\">\n  ");
		jteOutput.writeContent("\n  <link rel=\"stylesheet\" href=\"/plugins/adminlte/css/adminlte.css\">\n  ");
		jteOutput.writeContent("\n  <link rel=\"stylesheet\" href=\"//cdn.datatables.net/1.11.3/css/dataTables.bootstrap4.min.css\">\n  <link rel=\"stylesheet\" href=\"//cdn.datatables.net/responsive/2.2.3/css/responsive.bootstrap4.min.css\">\n  ");
		jteOutput.writeContent("\n  <script src=\"/plugins/adminlte/js/jquery.min.js\"></script>\n\n</head>\n\n<body class=\"hold-transition sidebar-mini sidebar-collapse\">\n  ");
		jteOutput.writeContent("\n  <div class=\"wrapper\">\n    ");
		jteOutput.writeContent("\n    <nav class=\"main-header navbar navbar-expand navbar-white navbar-light\">\n      ");
		jteOutput.writeContent("\n      <ul class=\"navbar-nav mr-auto\">\n        <li class=\"nav-item\">\n          <a class=\"nav-link\" data-widget=\"pushmenu\" href=\"#\" role=\"button\"><i class=\"fas fa-bars\"></i></a>\n        </li>\n      </ul>\n      <li class=\"nav-item dropdown\">\n        <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdown\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\n          Administrador\n        </a>\n        <div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">\n          <a class=\"dropdown-item\" href=\"/admin/perfil\">\n            <i class=\"fas fa-edit\"></i>\n            Editar perfil\n          </a>\n          <div class=\"dropdown-divider\"></div>\n          <a class=\"dropdown-item\" onclick=\"cerrarSesion()\">\n            <i class=\"fas fa-power-off\"></i>\n            Cerrar sesión\n          </a>\n        </div>\n      </li>\n    </nav>\n    ");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		render(jteOutput, jteHtmlInterceptor);
	}
}
