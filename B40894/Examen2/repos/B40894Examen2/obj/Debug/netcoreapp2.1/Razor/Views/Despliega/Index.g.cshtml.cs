#pragma checksum "C:\Users\Space\source\repos\B40894Examen2\Views\Despliega\Index.cshtml" "{ff1816ec-aa5e-4d10-87f7-6f4963833460}" "6562d5e21d7860e8f6b3af58587b0c933d58e6f0"
// <auto-generated/>
#pragma warning disable 1591
[assembly: global::Microsoft.AspNetCore.Razor.Hosting.RazorCompiledItemAttribute(typeof(AspNetCore.Views_Despliega_Index), @"mvc.1.0.view", @"/Views/Despliega/Index.cshtml")]
[assembly:global::Microsoft.AspNetCore.Mvc.Razor.Compilation.RazorViewAttribute(@"/Views/Despliega/Index.cshtml", typeof(AspNetCore.Views_Despliega_Index))]
namespace AspNetCore
{
    #line hidden
    using System;
    using System.Collections.Generic;
    using System.Linq;
    using System.Threading.Tasks;
    using Microsoft.AspNetCore.Mvc;
    using Microsoft.AspNetCore.Mvc.Rendering;
    using Microsoft.AspNetCore.Mvc.ViewFeatures;
#line 1 "C:\Users\Space\source\repos\B40894Examen2\Views\_ViewImports.cshtml"
using B40894Examen2;

#line default
#line hidden
#line 2 "C:\Users\Space\source\repos\B40894Examen2\Views\_ViewImports.cshtml"
using B40894Examen2.Models;

#line default
#line hidden
    [global::Microsoft.AspNetCore.Razor.Hosting.RazorSourceChecksumAttribute(@"SHA1", @"6562d5e21d7860e8f6b3af58587b0c933d58e6f0", @"/Views/Despliega/Index.cshtml")]
    [global::Microsoft.AspNetCore.Razor.Hosting.RazorSourceChecksumAttribute(@"SHA1", @"0303098b9e68dad10a3b3f2d1288760d3a922a36", @"/Views/_ViewImports.cshtml")]
    public class Views_Despliega_Index : global::Microsoft.AspNetCore.Mvc.Razor.RazorPage<IEnumerable<model.Domain.Departamento>>
    {
        #line hidden
        #pragma warning disable 0169
        private string __tagHelperStringValueBuffer;
        #pragma warning restore 0169
        private global::Microsoft.AspNetCore.Razor.Runtime.TagHelpers.TagHelperExecutionContext __tagHelperExecutionContext;
        private global::Microsoft.AspNetCore.Razor.Runtime.TagHelpers.TagHelperRunner __tagHelperRunner = new global::Microsoft.AspNetCore.Razor.Runtime.TagHelpers.TagHelperRunner();
        private global::Microsoft.AspNetCore.Razor.Runtime.TagHelpers.TagHelperScopeManager __backed__tagHelperScopeManager = null;
        private global::Microsoft.AspNetCore.Razor.Runtime.TagHelpers.TagHelperScopeManager __tagHelperScopeManager
        {
            get
            {
                if (__backed__tagHelperScopeManager == null)
                {
                    __backed__tagHelperScopeManager = new global::Microsoft.AspNetCore.Razor.Runtime.TagHelpers.TagHelperScopeManager(StartTagHelperWritingScope, EndTagHelperWritingScope);
                }
                return __backed__tagHelperScopeManager;
            }
        }
        private global::Microsoft.AspNetCore.Mvc.Razor.TagHelpers.HeadTagHelper __Microsoft_AspNetCore_Mvc_Razor_TagHelpers_HeadTagHelper;
        private global::Microsoft.AspNetCore.Mvc.Razor.TagHelpers.BodyTagHelper __Microsoft_AspNetCore_Mvc_Razor_TagHelpers_BodyTagHelper;
        #pragma warning disable 1998
        public async override global::System.Threading.Tasks.Task ExecuteAsync()
        {
            BeginContext(0, 2, true);
            WriteLiteral("\r\n");
            EndContext();
            BeginContext(51, 8, true);
            WriteLiteral("\r\n  \r\n\r\n");
            EndContext();
            BeginContext(83, 51, true);
            WriteLiteral("\r\n    <!DOCTYPE html>\r\n    <html lang=\"en\">\r\n\r\n    ");
            EndContext();
            BeginContext(134, 206, false);
            __tagHelperExecutionContext = __tagHelperScopeManager.Begin("head", global::Microsoft.AspNetCore.Razor.TagHelpers.TagMode.StartTagAndEndTag, "0bc5a7fd954b45e2b6c2dc1f11335909", async() => {
                BeginContext(140, 193, true);
                WriteLiteral("\r\n        <meta charset=\"utf-8\">\r\n        <meta name=\"viewport\" content=\"width=device-width,initial-scale=1\">\r\n        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/bootstrap.min.css\">\r\n    ");
                EndContext();
            }
            );
            __Microsoft_AspNetCore_Mvc_Razor_TagHelpers_HeadTagHelper = CreateTagHelper<global::Microsoft.AspNetCore.Mvc.Razor.TagHelpers.HeadTagHelper>();
            __tagHelperExecutionContext.Add(__Microsoft_AspNetCore_Mvc_Razor_TagHelpers_HeadTagHelper);
            await __tagHelperRunner.RunAsync(__tagHelperExecutionContext);
            if (!__tagHelperExecutionContext.Output.IsContentModified)
            {
                await __tagHelperExecutionContext.SetOutputContentAsync();
            }
            Write(__tagHelperExecutionContext.Output);
            __tagHelperExecutionContext = __tagHelperScopeManager.End();
            EndContext();
            BeginContext(340, 8, true);
            WriteLiteral("\r\n\r\n    ");
            EndContext();
            BeginContext(348, 1663, false);
            __tagHelperExecutionContext = __tagHelperScopeManager.Begin("body", global::Microsoft.AspNetCore.Razor.TagHelpers.TagMode.StartTagAndEndTag, "8963107574494be0bffcffddb5a619e5", async() => {
                BeginContext(354, 716, true);
                WriteLiteral(@"
        <div class=""container"">
            <h1>Organigrama </h1>
            <!--Bootstrap Basic Table using .table class-->
            <table class=""table"">
                <tr class=""text-center"">
                    <th>

                        <p class=""text-muted"">ID</p>
                    </th>
                    <th>

                        <p class=""text-muted"">Nombre</p>
                    </th>
                    <th>
                        <p class=""text-muted"">Seleccionado</p>
                    </th>
                    <th>
                        <p class=""text-muted"">Jefatura</p>
                    </th>
                    <th></th>
                </tr>

");
                EndContext();
#line 42 "C:\Users\Space\source\repos\B40894Examen2\Views\Despliega\Index.cshtml"
                 foreach (var departamento in Model)
                {

#line default
#line hidden
                BeginContext(1143, 82, true);
                WriteLiteral("            <tr class=\"text-center\">\r\n\r\n                <td>\r\n                    ");
                EndContext();
                BeginContext(1226, 27, false);
#line 47 "C:\Users\Space\source\repos\B40894Examen2\Views\Despliega\Index.cshtml"
               Write(departamento.IdDepartamento);

#line default
#line hidden
                EndContext();
                BeginContext(1253, 67, true);
                WriteLiteral("\r\n                </td>\r\n                <td>\r\n                    ");
                EndContext();
                BeginContext(1321, 19, false);
#line 50 "C:\Users\Space\source\repos\B40894Examen2\Views\Despliega\Index.cshtml"
               Write(departamento.Nombre);

#line default
#line hidden
                EndContext();
                BeginContext(1340, 67, true);
                WriteLiteral("\r\n                </td>\r\n                <th>\r\n                    ");
                EndContext();
                BeginContext(1408, 20, false);
#line 53 "C:\Users\Space\source\repos\B40894Examen2\Views\Despliega\Index.cshtml"
               Write(departamento.Marcado);

#line default
#line hidden
                EndContext();
                BeginContext(1428, 47, true);
                WriteLiteral("\r\n                </th>\r\n                <td>\r\n");
                EndContext();
#line 56 "C:\Users\Space\source\repos\B40894Examen2\Views\Despliega\Index.cshtml"
                     if (@departamento.Jefatura != null)
                    {
                        

#line default
#line hidden
                BeginContext(1581, 28, false);
#line 58 "C:\Users\Space\source\repos\B40894Examen2\Views\Despliega\Index.cshtml"
                   Write(departamento.Jefatura.Nombre);

#line default
#line hidden
                EndContext();
#line 58 "C:\Users\Space\source\repos\B40894Examen2\Views\Despliega\Index.cshtml"
                                                     
                    }

#line default
#line hidden
                BeginContext(1634, 65, true);
                WriteLiteral("                </td>\r\n                <td>\r\n                    ");
                EndContext();
                BeginContext(1700, 86, false);
#line 62 "C:\Users\Space\source\repos\B40894Examen2\Views\Despliega\Index.cshtml"
               Write(Html.ActionLink("Seleccionar", "Seleccion", new { id = @departamento.IdDepartamento }));

#line default
#line hidden
                EndContext();
                BeginContext(1786, 46, true);
                WriteLiteral("\r\n                </td>\r\n\r\n            </tr>\r\n");
                EndContext();
#line 66 "C:\Users\Space\source\repos\B40894Examen2\Views\Despliega\Index.cshtml"
                }

#line default
#line hidden
                BeginContext(1851, 153, true);
                WriteLiteral("\r\n            </table>\r\n        </div>\r\n        <script src=\"js/jquery-2.1.4.min.js\"></script>\r\n        <script src=\"js/bootstrap.min.js\"></script>\r\n    ");
                EndContext();
            }
            );
            __Microsoft_AspNetCore_Mvc_Razor_TagHelpers_BodyTagHelper = CreateTagHelper<global::Microsoft.AspNetCore.Mvc.Razor.TagHelpers.BodyTagHelper>();
            __tagHelperExecutionContext.Add(__Microsoft_AspNetCore_Mvc_Razor_TagHelpers_BodyTagHelper);
            await __tagHelperRunner.RunAsync(__tagHelperExecutionContext);
            if (!__tagHelperExecutionContext.Output.IsContentModified)
            {
                await __tagHelperExecutionContext.SetOutputContentAsync();
            }
            Write(__tagHelperExecutionContext.Output);
            __tagHelperExecutionContext = __tagHelperScopeManager.End();
            EndContext();
            BeginContext(2011, 13, true);
            WriteLiteral("\r\n\r\n</html>\r\n");
            EndContext();
        }
        #pragma warning restore 1998
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.ViewFeatures.IModelExpressionProvider ModelExpressionProvider { get; private set; }
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.IUrlHelper Url { get; private set; }
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.IViewComponentHelper Component { get; private set; }
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.Rendering.IJsonHelper Json { get; private set; }
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.Rendering.IHtmlHelper<IEnumerable<model.Domain.Departamento>> Html { get; private set; }
    }
}
#pragma warning restore 1591