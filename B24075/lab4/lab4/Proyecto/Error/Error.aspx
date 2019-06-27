<%@ Page Title="" Language="C#" MasterPageFile="~/SiteMaster.Master" AutoEventWireup="true" CodeBehind="Error.aspx.cs" Inherits="Proyecto.Error.Error" %>
<asp:Content ID="Content1" ContentPlaceHolderID="HeadContent" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="MainContent" runat="server">

    <div class="col-md-12 col-xs-12 col-sm-12 col-lg-12">
        <img src="../Imagenes/ERROR.jpg" class="img-thumbnail center-block" />
    </div>
    <div class="col-md-12 col-xs-12 col-sm-12 col-lg-12 text-center">
        <div class="alert alert-danger" role="alert">
            <h4 class="alert-heading">ERROR!</h4>
            <hr>
            <p class="mb-0">
                <asp:Label ID="lblError" runat="server" Text=""></asp:Label>
            </p>
        </div>
    </div>

    <div class="col-md-12 col-xs-12 col-sm-12 col-lg-12">
        <br />
    </div>

</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="ScriptContent" runat="server">
</asp:Content>
