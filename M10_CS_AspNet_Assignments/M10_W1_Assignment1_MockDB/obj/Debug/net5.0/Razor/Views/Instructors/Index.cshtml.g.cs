#pragma checksum "C:\Users\Dammy\OneDrive\Documents\Full Stack Programming\M10_CS_AspNet\Assignments\M10_W1_Assignment1_MockDB\Views\Instructors\Index.cshtml" "{ff1816ec-aa5e-4d10-87f7-6f4963833460}" "118d796b5e9dc56fe012b73e6b03b92daf7579d5"
// <auto-generated/>
#pragma warning disable 1591
[assembly: global::Microsoft.AspNetCore.Razor.Hosting.RazorCompiledItemAttribute(typeof(AspNetCore.Views_Instructors_Index), @"mvc.1.0.view", @"/Views/Instructors/Index.cshtml")]
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
#nullable restore
#line 1 "C:\Users\Dammy\OneDrive\Documents\Full Stack Programming\M10_CS_AspNet\Assignments\M10_W1_Assignment1_MockDB\Views\_ViewImports.cshtml"
using M10_W1_Assignment1_MockDB;

#line default
#line hidden
#nullable disable
#nullable restore
#line 2 "C:\Users\Dammy\OneDrive\Documents\Full Stack Programming\M10_CS_AspNet\Assignments\M10_W1_Assignment1_MockDB\Views\_ViewImports.cshtml"
using M10_W1_Assignment1_MockDB.Models;

#line default
#line hidden
#nullable disable
    [global::Microsoft.AspNetCore.Razor.Hosting.RazorSourceChecksumAttribute(@"SHA1", @"118d796b5e9dc56fe012b73e6b03b92daf7579d5", @"/Views/Instructors/Index.cshtml")]
    [global::Microsoft.AspNetCore.Razor.Hosting.RazorSourceChecksumAttribute(@"SHA1", @"272983b30a9964af8b5a71d7b47ac780071e8123", @"/Views/_ViewImports.cshtml")]
    public class Views_Instructors_Index : global::Microsoft.AspNetCore.Mvc.Razor.RazorPage<IEnumerable<M10_W1_Assignment1_MockDB.ModelsDto.InstructorDto>>
    {
        private static readonly global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute __tagHelperAttribute_0 = new global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute("asp-action", "Create", global::Microsoft.AspNetCore.Razor.TagHelpers.HtmlAttributeValueStyle.DoubleQuotes);
        #line hidden
        #pragma warning disable 0649
        private global::Microsoft.AspNetCore.Razor.Runtime.TagHelpers.TagHelperExecutionContext __tagHelperExecutionContext;
        #pragma warning restore 0649
        private global::Microsoft.AspNetCore.Razor.Runtime.TagHelpers.TagHelperRunner __tagHelperRunner = new global::Microsoft.AspNetCore.Razor.Runtime.TagHelpers.TagHelperRunner();
        #pragma warning disable 0169
        private string __tagHelperStringValueBuffer;
        #pragma warning restore 0169
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
        private global::Microsoft.AspNetCore.Mvc.TagHelpers.AnchorTagHelper __Microsoft_AspNetCore_Mvc_TagHelpers_AnchorTagHelper;
        #pragma warning disable 1998
        public async override global::System.Threading.Tasks.Task ExecuteAsync()
        {
            WriteLiteral("\r\n");
            WriteLiteral("\r\n");
#nullable restore
#line 6 "C:\Users\Dammy\OneDrive\Documents\Full Stack Programming\M10_CS_AspNet\Assignments\M10_W1_Assignment1_MockDB\Views\Instructors\Index.cshtml"
  
    ViewData["Title"] = "Index";

#line default
#line hidden
#nullable disable
            WriteLiteral("\r\n<h1>List of Instructors</h1>\r\n\r\n<p>\r\n    ");
            __tagHelperExecutionContext = __tagHelperScopeManager.Begin("a", global::Microsoft.AspNetCore.Razor.TagHelpers.TagMode.StartTagAndEndTag, "118d796b5e9dc56fe012b73e6b03b92daf7579d54022", async() => {
                WriteLiteral("Create New");
            }
            );
            __Microsoft_AspNetCore_Mvc_TagHelpers_AnchorTagHelper = CreateTagHelper<global::Microsoft.AspNetCore.Mvc.TagHelpers.AnchorTagHelper>();
            __tagHelperExecutionContext.Add(__Microsoft_AspNetCore_Mvc_TagHelpers_AnchorTagHelper);
            __Microsoft_AspNetCore_Mvc_TagHelpers_AnchorTagHelper.Action = (string)__tagHelperAttribute_0.Value;
            __tagHelperExecutionContext.AddTagHelperAttribute(__tagHelperAttribute_0);
            await __tagHelperRunner.RunAsync(__tagHelperExecutionContext);
            if (!__tagHelperExecutionContext.Output.IsContentModified)
            {
                await __tagHelperExecutionContext.SetOutputContentAsync();
            }
            Write(__tagHelperExecutionContext.Output);
            __tagHelperExecutionContext = __tagHelperScopeManager.End();
            WriteLiteral("\r\n</p>\r\n<table class=\"table\">\r\n    <thead>\r\n        <tr>\r\n            <th>\r\n                ");
#nullable restore
#line 19 "C:\Users\Dammy\OneDrive\Documents\Full Stack Programming\M10_CS_AspNet\Assignments\M10_W1_Assignment1_MockDB\Views\Instructors\Index.cshtml"
           Write(Html.DisplayNameFor(model => model.insID));

#line default
#line hidden
#nullable disable
            WriteLiteral("\r\n            </th>\r\n            <th>\r\n                ");
#nullable restore
#line 22 "C:\Users\Dammy\OneDrive\Documents\Full Stack Programming\M10_CS_AspNet\Assignments\M10_W1_Assignment1_MockDB\Views\Instructors\Index.cshtml"
           Write(Html.DisplayNameFor(model => model.firstName));

#line default
#line hidden
#nullable disable
            WriteLiteral("\r\n            </th>\r\n            <th>\r\n                ");
#nullable restore
#line 25 "C:\Users\Dammy\OneDrive\Documents\Full Stack Programming\M10_CS_AspNet\Assignments\M10_W1_Assignment1_MockDB\Views\Instructors\Index.cshtml"
           Write(Html.DisplayNameFor(model => model.lastName));

#line default
#line hidden
#nullable disable
            WriteLiteral("\r\n            </th>\r\n            <th>\r\n                ");
#nullable restore
#line 28 "C:\Users\Dammy\OneDrive\Documents\Full Stack Programming\M10_CS_AspNet\Assignments\M10_W1_Assignment1_MockDB\Views\Instructors\Index.cshtml"
           Write(Html.DisplayNameFor(model => model.email));

#line default
#line hidden
#nullable disable
            WriteLiteral("\r\n            </th>\r\n            <th>\r\n                ");
#nullable restore
#line 31 "C:\Users\Dammy\OneDrive\Documents\Full Stack Programming\M10_CS_AspNet\Assignments\M10_W1_Assignment1_MockDB\Views\Instructors\Index.cshtml"
           Write(Html.DisplayNameFor(model => model.courseID));

#line default
#line hidden
#nullable disable
            WriteLiteral("\r\n            </th>\r\n            <th></th>\r\n        </tr>\r\n    </thead>\r\n    <tbody>\r\n");
#nullable restore
#line 37 "C:\Users\Dammy\OneDrive\Documents\Full Stack Programming\M10_CS_AspNet\Assignments\M10_W1_Assignment1_MockDB\Views\Instructors\Index.cshtml"
         foreach (var item in Model) {

#line default
#line hidden
#nullable disable
            WriteLiteral("            <tr>\r\n                <td>\r\n                    ");
#nullable restore
#line 40 "C:\Users\Dammy\OneDrive\Documents\Full Stack Programming\M10_CS_AspNet\Assignments\M10_W1_Assignment1_MockDB\Views\Instructors\Index.cshtml"
               Write(Html.DisplayFor(modelItem => item.insID));

#line default
#line hidden
#nullable disable
            WriteLiteral("\r\n                </td>\r\n                <td>\r\n                    ");
#nullable restore
#line 43 "C:\Users\Dammy\OneDrive\Documents\Full Stack Programming\M10_CS_AspNet\Assignments\M10_W1_Assignment1_MockDB\Views\Instructors\Index.cshtml"
               Write(Html.DisplayFor(modelItem => item.firstName));

#line default
#line hidden
#nullable disable
            WriteLiteral("\r\n                </td>\r\n                <td>\r\n                    ");
#nullable restore
#line 46 "C:\Users\Dammy\OneDrive\Documents\Full Stack Programming\M10_CS_AspNet\Assignments\M10_W1_Assignment1_MockDB\Views\Instructors\Index.cshtml"
               Write(Html.DisplayFor(modelItem => item.lastName));

#line default
#line hidden
#nullable disable
            WriteLiteral("\r\n                </td>\r\n                <td>\r\n                    ");
#nullable restore
#line 49 "C:\Users\Dammy\OneDrive\Documents\Full Stack Programming\M10_CS_AspNet\Assignments\M10_W1_Assignment1_MockDB\Views\Instructors\Index.cshtml"
               Write(Html.DisplayFor(modelItem => item.email));

#line default
#line hidden
#nullable disable
            WriteLiteral("\r\n                </td>\r\n                <td>\r\n                    ");
#nullable restore
#line 52 "C:\Users\Dammy\OneDrive\Documents\Full Stack Programming\M10_CS_AspNet\Assignments\M10_W1_Assignment1_MockDB\Views\Instructors\Index.cshtml"
               Write(Html.DisplayFor(modelItem => item.courseID));

#line default
#line hidden
#nullable disable
            WriteLiteral("\r\n                </td>\r\n                <td");
            BeginWriteAttribute("onclick", " onclick=\"", 1521, "\"", 1649, 17);
            WriteAttributeValue("", 1531, "setInstructors(\'", 1531, 16, true);
#nullable restore
#line 54 "C:\Users\Dammy\OneDrive\Documents\Full Stack Programming\M10_CS_AspNet\Assignments\M10_W1_Assignment1_MockDB\Views\Instructors\Index.cshtml"
WriteAttributeValue("", 1547, item.insID, 1547, 11, false);

#line default
#line hidden
#nullable disable
            WriteAttributeValue("", 1558, "\',", 1558, 2, true);
            WriteAttributeValue(" ", 1560, "\'", 1561, 2, true);
#nullable restore
#line 54 "C:\Users\Dammy\OneDrive\Documents\Full Stack Programming\M10_CS_AspNet\Assignments\M10_W1_Assignment1_MockDB\Views\Instructors\Index.cshtml"
WriteAttributeValue("", 1562, item.firstName, 1562, 15, false);

#line default
#line hidden
#nullable disable
            WriteAttributeValue("", 1577, "\',", 1577, 2, true);
            WriteAttributeValue(" ", 1579, "\'", 1580, 2, true);
#nullable restore
#line 54 "C:\Users\Dammy\OneDrive\Documents\Full Stack Programming\M10_CS_AspNet\Assignments\M10_W1_Assignment1_MockDB\Views\Instructors\Index.cshtml"
WriteAttributeValue("", 1581, item.lastName, 1581, 14, false);

#line default
#line hidden
#nullable disable
            WriteAttributeValue("", 1595, "\',", 1595, 2, true);
            WriteAttributeValue(" ", 1597, "\'", 1598, 2, true);
#nullable restore
#line 54 "C:\Users\Dammy\OneDrive\Documents\Full Stack Programming\M10_CS_AspNet\Assignments\M10_W1_Assignment1_MockDB\Views\Instructors\Index.cshtml"
WriteAttributeValue("", 1599, item.email, 1599, 11, false);

#line default
#line hidden
#nullable disable
            WriteAttributeValue("", 1610, "\',", 1610, 2, true);
            WriteAttributeValue(" ", 1612, "\'", 1613, 2, true);
#nullable restore
#line 54 "C:\Users\Dammy\OneDrive\Documents\Full Stack Programming\M10_CS_AspNet\Assignments\M10_W1_Assignment1_MockDB\Views\Instructors\Index.cshtml"
WriteAttributeValue("", 1614, item.courseID, 1614, 14, false);

#line default
#line hidden
#nullable disable
            WriteAttributeValue("", 1628, "\');", 1628, 3, true);
            WriteAttributeValue(" ", 1631, "getInstructors()", 1632, 17, true);
            WriteAttributeValue(" ", 1648, "", 1649, 1, true);
            EndWriteAttribute();
            WriteLiteral(">\r\n                    ");
#nullable restore
#line 55 "C:\Users\Dammy\OneDrive\Documents\Full Stack Programming\M10_CS_AspNet\Assignments\M10_W1_Assignment1_MockDB\Views\Instructors\Index.cshtml"
               Write(Html.ActionLink("Edit", "Edit", new { /* id=item.PrimaryKey */ }));

#line default
#line hidden
#nullable disable
            WriteLiteral(" |\r\n                    ");
#nullable restore
#line 56 "C:\Users\Dammy\OneDrive\Documents\Full Stack Programming\M10_CS_AspNet\Assignments\M10_W1_Assignment1_MockDB\Views\Instructors\Index.cshtml"
               Write(Html.ActionLink("Details", "Details", new { /* id=item.PrimaryKey */ }));

#line default
#line hidden
#nullable disable
            WriteLiteral(" |\r\n                    ");
#nullable restore
#line 57 "C:\Users\Dammy\OneDrive\Documents\Full Stack Programming\M10_CS_AspNet\Assignments\M10_W1_Assignment1_MockDB\Views\Instructors\Index.cshtml"
               Write(Html.ActionLink("Delete", "Delete", new { /* id=item.PrimaryKey */ }));

#line default
#line hidden
#nullable disable
            WriteLiteral("\r\n                </td>\r\n            </tr>\r\n");
#nullable restore
#line 60 "C:\Users\Dammy\OneDrive\Documents\Full Stack Programming\M10_CS_AspNet\Assignments\M10_W1_Assignment1_MockDB\Views\Instructors\Index.cshtml"
        }

#line default
#line hidden
#nullable disable
            WriteLiteral("    </tbody>\r\n</table>\r\n");
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
        public global::Microsoft.AspNetCore.Mvc.Rendering.IHtmlHelper<IEnumerable<M10_W1_Assignment1_MockDB.ModelsDto.InstructorDto>> Html { get; private set; }
    }
}
#pragma warning restore 1591
