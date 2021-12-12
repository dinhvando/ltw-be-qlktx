﻿//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated by a tool.
//     Runtime Version:4.0.30319.42000
//
//     Changes to this file may cause incorrect behavior and will be lost if
//     the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

using System;
using System.ComponentModel;
using System.Diagnostics;
using System.Web.Services;
using System.Web.Services.Protocols;
using System.Xml.Serialization;

// 
// This source code was auto-generated by wsdl, Version=4.8.3928.0.
// 


/// <remarks/>
[System.CodeDom.Compiler.GeneratedCodeAttribute("wsdl", "4.8.3928.0")]
[System.Diagnostics.DebuggerStepThroughAttribute()]
[System.ComponentModel.DesignerCategoryAttribute("code")]
[System.Web.Services.WebServiceBindingAttribute(Name="SampleWebServicesSoap", Namespace="http://wwww.hocvienmang.com/")]
public partial class SampleWebServices : System.Web.Services.Protocols.SoapHttpClientProtocol {
    
    private System.Threading.SendOrPostCallback HelloOperationCompleted;
    
    private System.Threading.SendOrPostCallback GetLocalDateTimeOperationCompleted;
    
    private System.Threading.SendOrPostCallback GetLocalDateTimeTicksOperationCompleted;
    
    private System.Threading.SendOrPostCallback GetUtcDateTimeOperationCompleted;
    
    private System.Threading.SendOrPostCallback GetUtcDateTimeTicksOperationCompleted;
    
    private System.Threading.SendOrPostCallback GetLocalDiffernceTicksOperationCompleted;
    
    private System.Threading.SendOrPostCallback GetUtcDiffernceTicksOperationCompleted;
    
    private System.Threading.SendOrPostCallback GetLocalDateTimeAndDiffernceTicksOperationCompleted;
    
    private System.Threading.SendOrPostCallback GetUtcDateTimeAndDiffernceTicksOperationCompleted;
    
    /// <remarks/>
    public SampleWebServices() {
        this.Url = "http://103.3.252.222/DsWebServices/SampleWebServices.asmx";
    }
    
    /// <remarks/>
    public event HelloCompletedEventHandler HelloCompleted;
    
    /// <remarks/>
    public event GetLocalDateTimeCompletedEventHandler GetLocalDateTimeCompleted;
    
    /// <remarks/>
    public event GetLocalDateTimeTicksCompletedEventHandler GetLocalDateTimeTicksCompleted;
    
    /// <remarks/>
    public event GetUtcDateTimeCompletedEventHandler GetUtcDateTimeCompleted;
    
    /// <remarks/>
    public event GetUtcDateTimeTicksCompletedEventHandler GetUtcDateTimeTicksCompleted;
    
    /// <remarks/>
    public event GetLocalDiffernceTicksCompletedEventHandler GetLocalDiffernceTicksCompleted;
    
    /// <remarks/>
    public event GetUtcDiffernceTicksCompletedEventHandler GetUtcDiffernceTicksCompleted;
    
    /// <remarks/>
    public event GetLocalDateTimeAndDiffernceTicksCompletedEventHandler GetLocalDateTimeAndDiffernceTicksCompleted;
    
    /// <remarks/>
    public event GetUtcDateTimeAndDiffernceTicksCompletedEventHandler GetUtcDateTimeAndDiffernceTicksCompleted;
    
    /// <remarks/>
    [System.Web.Services.Protocols.SoapDocumentMethodAttribute("http://wwww.hocvienmang.com/Hello", RequestNamespace="http://wwww.hocvienmang.com/", ResponseNamespace="http://wwww.hocvienmang.com/", Use=System.Web.Services.Description.SoapBindingUse.Literal, ParameterStyle=System.Web.Services.Protocols.SoapParameterStyle.Wrapped)]
    public string Hello(string UserName) {
        object[] results = this.Invoke("Hello", new object[] {
                    UserName});
        return ((string)(results[0]));
    }
    
    /// <remarks/>
    public System.IAsyncResult BeginHello(string UserName, System.AsyncCallback callback, object asyncState) {
        return this.BeginInvoke("Hello", new object[] {
                    UserName}, callback, asyncState);
    }
    
    /// <remarks/>
    public string EndHello(System.IAsyncResult asyncResult) {
        object[] results = this.EndInvoke(asyncResult);
        return ((string)(results[0]));
    }
    
    /// <remarks/>
    public void HelloAsync(string UserName) {
        this.HelloAsync(UserName, null);
    }
    
    /// <remarks/>
    public void HelloAsync(string UserName, object userState) {
        if ((this.HelloOperationCompleted == null)) {
            this.HelloOperationCompleted = new System.Threading.SendOrPostCallback(this.OnHelloOperationCompleted);
        }
        this.InvokeAsync("Hello", new object[] {
                    UserName}, this.HelloOperationCompleted, userState);
    }
    
    private void OnHelloOperationCompleted(object arg) {
        if ((this.HelloCompleted != null)) {
            System.Web.Services.Protocols.InvokeCompletedEventArgs invokeArgs = ((System.Web.Services.Protocols.InvokeCompletedEventArgs)(arg));
            this.HelloCompleted(this, new HelloCompletedEventArgs(invokeArgs.Results, invokeArgs.Error, invokeArgs.Cancelled, invokeArgs.UserState));
        }
    }
    
    /// <remarks/>
    [System.Web.Services.Protocols.SoapDocumentMethodAttribute("http://wwww.hocvienmang.com/GetLocalDateTime", RequestNamespace="http://wwww.hocvienmang.com/", ResponseNamespace="http://wwww.hocvienmang.com/", Use=System.Web.Services.Description.SoapBindingUse.Literal, ParameterStyle=System.Web.Services.Protocols.SoapParameterStyle.Wrapped)]
    public System.DateTime GetLocalDateTime() {
        object[] results = this.Invoke("GetLocalDateTime", new object[0]);
        return ((System.DateTime)(results[0]));
    }
    
    /// <remarks/>
    public System.IAsyncResult BeginGetLocalDateTime(System.AsyncCallback callback, object asyncState) {
        return this.BeginInvoke("GetLocalDateTime", new object[0], callback, asyncState);
    }
    
    /// <remarks/>
    public System.DateTime EndGetLocalDateTime(System.IAsyncResult asyncResult) {
        object[] results = this.EndInvoke(asyncResult);
        return ((System.DateTime)(results[0]));
    }
    
    /// <remarks/>
    public void GetLocalDateTimeAsync() {
        this.GetLocalDateTimeAsync(null);
    }
    
    /// <remarks/>
    public void GetLocalDateTimeAsync(object userState) {
        if ((this.GetLocalDateTimeOperationCompleted == null)) {
            this.GetLocalDateTimeOperationCompleted = new System.Threading.SendOrPostCallback(this.OnGetLocalDateTimeOperationCompleted);
        }
        this.InvokeAsync("GetLocalDateTime", new object[0], this.GetLocalDateTimeOperationCompleted, userState);
    }
    
    private void OnGetLocalDateTimeOperationCompleted(object arg) {
        if ((this.GetLocalDateTimeCompleted != null)) {
            System.Web.Services.Protocols.InvokeCompletedEventArgs invokeArgs = ((System.Web.Services.Protocols.InvokeCompletedEventArgs)(arg));
            this.GetLocalDateTimeCompleted(this, new GetLocalDateTimeCompletedEventArgs(invokeArgs.Results, invokeArgs.Error, invokeArgs.Cancelled, invokeArgs.UserState));
        }
    }
    
    /// <remarks/>
    [System.Web.Services.Protocols.SoapDocumentMethodAttribute("http://wwww.hocvienmang.com/GetLocalDateTimeTicks", RequestNamespace="http://wwww.hocvienmang.com/", ResponseNamespace="http://wwww.hocvienmang.com/", Use=System.Web.Services.Description.SoapBindingUse.Literal, ParameterStyle=System.Web.Services.Protocols.SoapParameterStyle.Wrapped)]
    public long GetLocalDateTimeTicks() {
        object[] results = this.Invoke("GetLocalDateTimeTicks", new object[0]);
        return ((long)(results[0]));
    }
    
    /// <remarks/>
    public System.IAsyncResult BeginGetLocalDateTimeTicks(System.AsyncCallback callback, object asyncState) {
        return this.BeginInvoke("GetLocalDateTimeTicks", new object[0], callback, asyncState);
    }
    
    /// <remarks/>
    public long EndGetLocalDateTimeTicks(System.IAsyncResult asyncResult) {
        object[] results = this.EndInvoke(asyncResult);
        return ((long)(results[0]));
    }
    
    /// <remarks/>
    public void GetLocalDateTimeTicksAsync() {
        this.GetLocalDateTimeTicksAsync(null);
    }
    
    /// <remarks/>
    public void GetLocalDateTimeTicksAsync(object userState) {
        if ((this.GetLocalDateTimeTicksOperationCompleted == null)) {
            this.GetLocalDateTimeTicksOperationCompleted = new System.Threading.SendOrPostCallback(this.OnGetLocalDateTimeTicksOperationCompleted);
        }
        this.InvokeAsync("GetLocalDateTimeTicks", new object[0], this.GetLocalDateTimeTicksOperationCompleted, userState);
    }
    
    private void OnGetLocalDateTimeTicksOperationCompleted(object arg) {
        if ((this.GetLocalDateTimeTicksCompleted != null)) {
            System.Web.Services.Protocols.InvokeCompletedEventArgs invokeArgs = ((System.Web.Services.Protocols.InvokeCompletedEventArgs)(arg));
            this.GetLocalDateTimeTicksCompleted(this, new GetLocalDateTimeTicksCompletedEventArgs(invokeArgs.Results, invokeArgs.Error, invokeArgs.Cancelled, invokeArgs.UserState));
        }
    }
    
    /// <remarks/>
    [System.Web.Services.Protocols.SoapDocumentMethodAttribute("http://wwww.hocvienmang.com/GetUtcDateTime", RequestNamespace="http://wwww.hocvienmang.com/", ResponseNamespace="http://wwww.hocvienmang.com/", Use=System.Web.Services.Description.SoapBindingUse.Literal, ParameterStyle=System.Web.Services.Protocols.SoapParameterStyle.Wrapped)]
    public System.DateTime GetUtcDateTime() {
        object[] results = this.Invoke("GetUtcDateTime", new object[0]);
        return ((System.DateTime)(results[0]));
    }
    
    /// <remarks/>
    public System.IAsyncResult BeginGetUtcDateTime(System.AsyncCallback callback, object asyncState) {
        return this.BeginInvoke("GetUtcDateTime", new object[0], callback, asyncState);
    }
    
    /// <remarks/>
    public System.DateTime EndGetUtcDateTime(System.IAsyncResult asyncResult) {
        object[] results = this.EndInvoke(asyncResult);
        return ((System.DateTime)(results[0]));
    }
    
    /// <remarks/>
    public void GetUtcDateTimeAsync() {
        this.GetUtcDateTimeAsync(null);
    }
    
    /// <remarks/>
    public void GetUtcDateTimeAsync(object userState) {
        if ((this.GetUtcDateTimeOperationCompleted == null)) {
            this.GetUtcDateTimeOperationCompleted = new System.Threading.SendOrPostCallback(this.OnGetUtcDateTimeOperationCompleted);
        }
        this.InvokeAsync("GetUtcDateTime", new object[0], this.GetUtcDateTimeOperationCompleted, userState);
    }
    
    private void OnGetUtcDateTimeOperationCompleted(object arg) {
        if ((this.GetUtcDateTimeCompleted != null)) {
            System.Web.Services.Protocols.InvokeCompletedEventArgs invokeArgs = ((System.Web.Services.Protocols.InvokeCompletedEventArgs)(arg));
            this.GetUtcDateTimeCompleted(this, new GetUtcDateTimeCompletedEventArgs(invokeArgs.Results, invokeArgs.Error, invokeArgs.Cancelled, invokeArgs.UserState));
        }
    }
    
    /// <remarks/>
    [System.Web.Services.Protocols.SoapDocumentMethodAttribute("http://wwww.hocvienmang.com/GetUtcDateTimeTicks", RequestNamespace="http://wwww.hocvienmang.com/", ResponseNamespace="http://wwww.hocvienmang.com/", Use=System.Web.Services.Description.SoapBindingUse.Literal, ParameterStyle=System.Web.Services.Protocols.SoapParameterStyle.Wrapped)]
    public long GetUtcDateTimeTicks() {
        object[] results = this.Invoke("GetUtcDateTimeTicks", new object[0]);
        return ((long)(results[0]));
    }
    
    /// <remarks/>
    public System.IAsyncResult BeginGetUtcDateTimeTicks(System.AsyncCallback callback, object asyncState) {
        return this.BeginInvoke("GetUtcDateTimeTicks", new object[0], callback, asyncState);
    }
    
    /// <remarks/>
    public long EndGetUtcDateTimeTicks(System.IAsyncResult asyncResult) {
        object[] results = this.EndInvoke(asyncResult);
        return ((long)(results[0]));
    }
    
    /// <remarks/>
    public void GetUtcDateTimeTicksAsync() {
        this.GetUtcDateTimeTicksAsync(null);
    }
    
    /// <remarks/>
    public void GetUtcDateTimeTicksAsync(object userState) {
        if ((this.GetUtcDateTimeTicksOperationCompleted == null)) {
            this.GetUtcDateTimeTicksOperationCompleted = new System.Threading.SendOrPostCallback(this.OnGetUtcDateTimeTicksOperationCompleted);
        }
        this.InvokeAsync("GetUtcDateTimeTicks", new object[0], this.GetUtcDateTimeTicksOperationCompleted, userState);
    }
    
    private void OnGetUtcDateTimeTicksOperationCompleted(object arg) {
        if ((this.GetUtcDateTimeTicksCompleted != null)) {
            System.Web.Services.Protocols.InvokeCompletedEventArgs invokeArgs = ((System.Web.Services.Protocols.InvokeCompletedEventArgs)(arg));
            this.GetUtcDateTimeTicksCompleted(this, new GetUtcDateTimeTicksCompletedEventArgs(invokeArgs.Results, invokeArgs.Error, invokeArgs.Cancelled, invokeArgs.UserState));
        }
    }
    
    /// <remarks/>
    [System.Web.Services.Protocols.SoapDocumentMethodAttribute("http://wwww.hocvienmang.com/GetLocalDiffernceTicks", RequestNamespace="http://wwww.hocvienmang.com/", ResponseNamespace="http://wwww.hocvienmang.com/", Use=System.Web.Services.Description.SoapBindingUse.Literal, ParameterStyle=System.Web.Services.Protocols.SoapParameterStyle.Wrapped)]
    public long GetLocalDiffernceTicks(long ClientLocalDateTimeTicks) {
        object[] results = this.Invoke("GetLocalDiffernceTicks", new object[] {
                    ClientLocalDateTimeTicks});
        return ((long)(results[0]));
    }
    
    /// <remarks/>
    public System.IAsyncResult BeginGetLocalDiffernceTicks(long ClientLocalDateTimeTicks, System.AsyncCallback callback, object asyncState) {
        return this.BeginInvoke("GetLocalDiffernceTicks", new object[] {
                    ClientLocalDateTimeTicks}, callback, asyncState);
    }
    
    /// <remarks/>
    public long EndGetLocalDiffernceTicks(System.IAsyncResult asyncResult) {
        object[] results = this.EndInvoke(asyncResult);
        return ((long)(results[0]));
    }
    
    /// <remarks/>
    public void GetLocalDiffernceTicksAsync(long ClientLocalDateTimeTicks) {
        this.GetLocalDiffernceTicksAsync(ClientLocalDateTimeTicks, null);
    }
    
    /// <remarks/>
    public void GetLocalDiffernceTicksAsync(long ClientLocalDateTimeTicks, object userState) {
        if ((this.GetLocalDiffernceTicksOperationCompleted == null)) {
            this.GetLocalDiffernceTicksOperationCompleted = new System.Threading.SendOrPostCallback(this.OnGetLocalDiffernceTicksOperationCompleted);
        }
        this.InvokeAsync("GetLocalDiffernceTicks", new object[] {
                    ClientLocalDateTimeTicks}, this.GetLocalDiffernceTicksOperationCompleted, userState);
    }
    
    private void OnGetLocalDiffernceTicksOperationCompleted(object arg) {
        if ((this.GetLocalDiffernceTicksCompleted != null)) {
            System.Web.Services.Protocols.InvokeCompletedEventArgs invokeArgs = ((System.Web.Services.Protocols.InvokeCompletedEventArgs)(arg));
            this.GetLocalDiffernceTicksCompleted(this, new GetLocalDiffernceTicksCompletedEventArgs(invokeArgs.Results, invokeArgs.Error, invokeArgs.Cancelled, invokeArgs.UserState));
        }
    }
    
    /// <remarks/>
    [System.Web.Services.Protocols.SoapDocumentMethodAttribute("http://wwww.hocvienmang.com/GetUtcDiffernceTicks", RequestNamespace="http://wwww.hocvienmang.com/", ResponseNamespace="http://wwww.hocvienmang.com/", Use=System.Web.Services.Description.SoapBindingUse.Literal, ParameterStyle=System.Web.Services.Protocols.SoapParameterStyle.Wrapped)]
    public long GetUtcDiffernceTicks(long ClientUtcDateTimeTicks) {
        object[] results = this.Invoke("GetUtcDiffernceTicks", new object[] {
                    ClientUtcDateTimeTicks});
        return ((long)(results[0]));
    }
    
    /// <remarks/>
    public System.IAsyncResult BeginGetUtcDiffernceTicks(long ClientUtcDateTimeTicks, System.AsyncCallback callback, object asyncState) {
        return this.BeginInvoke("GetUtcDiffernceTicks", new object[] {
                    ClientUtcDateTimeTicks}, callback, asyncState);
    }
    
    /// <remarks/>
    public long EndGetUtcDiffernceTicks(System.IAsyncResult asyncResult) {
        object[] results = this.EndInvoke(asyncResult);
        return ((long)(results[0]));
    }
    
    /// <remarks/>
    public void GetUtcDiffernceTicksAsync(long ClientUtcDateTimeTicks) {
        this.GetUtcDiffernceTicksAsync(ClientUtcDateTimeTicks, null);
    }
    
    /// <remarks/>
    public void GetUtcDiffernceTicksAsync(long ClientUtcDateTimeTicks, object userState) {
        if ((this.GetUtcDiffernceTicksOperationCompleted == null)) {
            this.GetUtcDiffernceTicksOperationCompleted = new System.Threading.SendOrPostCallback(this.OnGetUtcDiffernceTicksOperationCompleted);
        }
        this.InvokeAsync("GetUtcDiffernceTicks", new object[] {
                    ClientUtcDateTimeTicks}, this.GetUtcDiffernceTicksOperationCompleted, userState);
    }
    
    private void OnGetUtcDiffernceTicksOperationCompleted(object arg) {
        if ((this.GetUtcDiffernceTicksCompleted != null)) {
            System.Web.Services.Protocols.InvokeCompletedEventArgs invokeArgs = ((System.Web.Services.Protocols.InvokeCompletedEventArgs)(arg));
            this.GetUtcDiffernceTicksCompleted(this, new GetUtcDiffernceTicksCompletedEventArgs(invokeArgs.Results, invokeArgs.Error, invokeArgs.Cancelled, invokeArgs.UserState));
        }
    }
    
    /// <remarks/>
    [System.Web.Services.Protocols.SoapDocumentMethodAttribute("http://wwww.hocvienmang.com/GetLocalDateTimeAndDiffernceTicks", RequestNamespace="http://wwww.hocvienmang.com/", ResponseNamespace="http://wwww.hocvienmang.com/", Use=System.Web.Services.Description.SoapBindingUse.Literal, ParameterStyle=System.Web.Services.Protocols.SoapParameterStyle.Wrapped)]
    public System.DateTime GetLocalDateTimeAndDiffernceTicks(long ClientLocalDateTimeTicks, ref long DiffernceTicks) {
        object[] results = this.Invoke("GetLocalDateTimeAndDiffernceTicks", new object[] {
                    ClientLocalDateTimeTicks,
                    DiffernceTicks});
        DiffernceTicks = ((long)(results[1]));
        return ((System.DateTime)(results[0]));
    }
    
    /// <remarks/>
    public System.IAsyncResult BeginGetLocalDateTimeAndDiffernceTicks(long ClientLocalDateTimeTicks, long DiffernceTicks, System.AsyncCallback callback, object asyncState) {
        return this.BeginInvoke("GetLocalDateTimeAndDiffernceTicks", new object[] {
                    ClientLocalDateTimeTicks,
                    DiffernceTicks}, callback, asyncState);
    }
    
    /// <remarks/>
    public System.DateTime EndGetLocalDateTimeAndDiffernceTicks(System.IAsyncResult asyncResult, out long DiffernceTicks) {
        object[] results = this.EndInvoke(asyncResult);
        DiffernceTicks = ((long)(results[1]));
        return ((System.DateTime)(results[0]));
    }
    
    /// <remarks/>
    public void GetLocalDateTimeAndDiffernceTicksAsync(long ClientLocalDateTimeTicks, long DiffernceTicks) {
        this.GetLocalDateTimeAndDiffernceTicksAsync(ClientLocalDateTimeTicks, DiffernceTicks, null);
    }
    
    /// <remarks/>
    public void GetLocalDateTimeAndDiffernceTicksAsync(long ClientLocalDateTimeTicks, long DiffernceTicks, object userState) {
        if ((this.GetLocalDateTimeAndDiffernceTicksOperationCompleted == null)) {
            this.GetLocalDateTimeAndDiffernceTicksOperationCompleted = new System.Threading.SendOrPostCallback(this.OnGetLocalDateTimeAndDiffernceTicksOperationCompleted);
        }
        this.InvokeAsync("GetLocalDateTimeAndDiffernceTicks", new object[] {
                    ClientLocalDateTimeTicks,
                    DiffernceTicks}, this.GetLocalDateTimeAndDiffernceTicksOperationCompleted, userState);
    }
    
    private void OnGetLocalDateTimeAndDiffernceTicksOperationCompleted(object arg) {
        if ((this.GetLocalDateTimeAndDiffernceTicksCompleted != null)) {
            System.Web.Services.Protocols.InvokeCompletedEventArgs invokeArgs = ((System.Web.Services.Protocols.InvokeCompletedEventArgs)(arg));
            this.GetLocalDateTimeAndDiffernceTicksCompleted(this, new GetLocalDateTimeAndDiffernceTicksCompletedEventArgs(invokeArgs.Results, invokeArgs.Error, invokeArgs.Cancelled, invokeArgs.UserState));
        }
    }
    
    /// <remarks/>
    [System.Web.Services.Protocols.SoapDocumentMethodAttribute("http://wwww.hocvienmang.com/GetUtcDateTimeAndDiffernceTicks", RequestNamespace="http://wwww.hocvienmang.com/", ResponseNamespace="http://wwww.hocvienmang.com/", Use=System.Web.Services.Description.SoapBindingUse.Literal, ParameterStyle=System.Web.Services.Protocols.SoapParameterStyle.Wrapped)]
    public System.DateTime GetUtcDateTimeAndDiffernceTicks(long ClientUtcDateTimeTicks, ref long DiffernceTicks) {
        object[] results = this.Invoke("GetUtcDateTimeAndDiffernceTicks", new object[] {
                    ClientUtcDateTimeTicks,
                    DiffernceTicks});
        DiffernceTicks = ((long)(results[1]));
        return ((System.DateTime)(results[0]));
    }
    
    /// <remarks/>
    public System.IAsyncResult BeginGetUtcDateTimeAndDiffernceTicks(long ClientUtcDateTimeTicks, long DiffernceTicks, System.AsyncCallback callback, object asyncState) {
        return this.BeginInvoke("GetUtcDateTimeAndDiffernceTicks", new object[] {
                    ClientUtcDateTimeTicks,
                    DiffernceTicks}, callback, asyncState);
    }
    
    /// <remarks/>
    public System.DateTime EndGetUtcDateTimeAndDiffernceTicks(System.IAsyncResult asyncResult, out long DiffernceTicks) {
        object[] results = this.EndInvoke(asyncResult);
        DiffernceTicks = ((long)(results[1]));
        return ((System.DateTime)(results[0]));
    }
    
    /// <remarks/>
    public void GetUtcDateTimeAndDiffernceTicksAsync(long ClientUtcDateTimeTicks, long DiffernceTicks) {
        this.GetUtcDateTimeAndDiffernceTicksAsync(ClientUtcDateTimeTicks, DiffernceTicks, null);
    }
    
    /// <remarks/>
    public void GetUtcDateTimeAndDiffernceTicksAsync(long ClientUtcDateTimeTicks, long DiffernceTicks, object userState) {
        if ((this.GetUtcDateTimeAndDiffernceTicksOperationCompleted == null)) {
            this.GetUtcDateTimeAndDiffernceTicksOperationCompleted = new System.Threading.SendOrPostCallback(this.OnGetUtcDateTimeAndDiffernceTicksOperationCompleted);
        }
        this.InvokeAsync("GetUtcDateTimeAndDiffernceTicks", new object[] {
                    ClientUtcDateTimeTicks,
                    DiffernceTicks}, this.GetUtcDateTimeAndDiffernceTicksOperationCompleted, userState);
    }
    
    private void OnGetUtcDateTimeAndDiffernceTicksOperationCompleted(object arg) {
        if ((this.GetUtcDateTimeAndDiffernceTicksCompleted != null)) {
            System.Web.Services.Protocols.InvokeCompletedEventArgs invokeArgs = ((System.Web.Services.Protocols.InvokeCompletedEventArgs)(arg));
            this.GetUtcDateTimeAndDiffernceTicksCompleted(this, new GetUtcDateTimeAndDiffernceTicksCompletedEventArgs(invokeArgs.Results, invokeArgs.Error, invokeArgs.Cancelled, invokeArgs.UserState));
        }
    }
    
    /// <remarks/>
    public new void CancelAsync(object userState) {
        base.CancelAsync(userState);
    }
}

/// <remarks/>
[System.CodeDom.Compiler.GeneratedCodeAttribute("wsdl", "4.8.3928.0")]
public delegate void HelloCompletedEventHandler(object sender, HelloCompletedEventArgs e);

/// <remarks/>
[System.CodeDom.Compiler.GeneratedCodeAttribute("wsdl", "4.8.3928.0")]
[System.Diagnostics.DebuggerStepThroughAttribute()]
[System.ComponentModel.DesignerCategoryAttribute("code")]
public partial class HelloCompletedEventArgs : System.ComponentModel.AsyncCompletedEventArgs {
    
    private object[] results;
    
    internal HelloCompletedEventArgs(object[] results, System.Exception exception, bool cancelled, object userState) : 
            base(exception, cancelled, userState) {
        this.results = results;
    }
    
    /// <remarks/>
    public string Result {
        get {
            this.RaiseExceptionIfNecessary();
            return ((string)(this.results[0]));
        }
    }
}

/// <remarks/>
[System.CodeDom.Compiler.GeneratedCodeAttribute("wsdl", "4.8.3928.0")]
public delegate void GetLocalDateTimeCompletedEventHandler(object sender, GetLocalDateTimeCompletedEventArgs e);

/// <remarks/>
[System.CodeDom.Compiler.GeneratedCodeAttribute("wsdl", "4.8.3928.0")]
[System.Diagnostics.DebuggerStepThroughAttribute()]
[System.ComponentModel.DesignerCategoryAttribute("code")]
public partial class GetLocalDateTimeCompletedEventArgs : System.ComponentModel.AsyncCompletedEventArgs {
    
    private object[] results;
    
    internal GetLocalDateTimeCompletedEventArgs(object[] results, System.Exception exception, bool cancelled, object userState) : 
            base(exception, cancelled, userState) {
        this.results = results;
    }
    
    /// <remarks/>
    public System.DateTime Result {
        get {
            this.RaiseExceptionIfNecessary();
            return ((System.DateTime)(this.results[0]));
        }
    }
}

/// <remarks/>
[System.CodeDom.Compiler.GeneratedCodeAttribute("wsdl", "4.8.3928.0")]
public delegate void GetLocalDateTimeTicksCompletedEventHandler(object sender, GetLocalDateTimeTicksCompletedEventArgs e);

/// <remarks/>
[System.CodeDom.Compiler.GeneratedCodeAttribute("wsdl", "4.8.3928.0")]
[System.Diagnostics.DebuggerStepThroughAttribute()]
[System.ComponentModel.DesignerCategoryAttribute("code")]
public partial class GetLocalDateTimeTicksCompletedEventArgs : System.ComponentModel.AsyncCompletedEventArgs {
    
    private object[] results;
    
    internal GetLocalDateTimeTicksCompletedEventArgs(object[] results, System.Exception exception, bool cancelled, object userState) : 
            base(exception, cancelled, userState) {
        this.results = results;
    }
    
    /// <remarks/>
    public long Result {
        get {
            this.RaiseExceptionIfNecessary();
            return ((long)(this.results[0]));
        }
    }
}

/// <remarks/>
[System.CodeDom.Compiler.GeneratedCodeAttribute("wsdl", "4.8.3928.0")]
public delegate void GetUtcDateTimeCompletedEventHandler(object sender, GetUtcDateTimeCompletedEventArgs e);

/// <remarks/>
[System.CodeDom.Compiler.GeneratedCodeAttribute("wsdl", "4.8.3928.0")]
[System.Diagnostics.DebuggerStepThroughAttribute()]
[System.ComponentModel.DesignerCategoryAttribute("code")]
public partial class GetUtcDateTimeCompletedEventArgs : System.ComponentModel.AsyncCompletedEventArgs {
    
    private object[] results;
    
    internal GetUtcDateTimeCompletedEventArgs(object[] results, System.Exception exception, bool cancelled, object userState) : 
            base(exception, cancelled, userState) {
        this.results = results;
    }
    
    /// <remarks/>
    public System.DateTime Result {
        get {
            this.RaiseExceptionIfNecessary();
            return ((System.DateTime)(this.results[0]));
        }
    }
}

/// <remarks/>
[System.CodeDom.Compiler.GeneratedCodeAttribute("wsdl", "4.8.3928.0")]
public delegate void GetUtcDateTimeTicksCompletedEventHandler(object sender, GetUtcDateTimeTicksCompletedEventArgs e);

/// <remarks/>
[System.CodeDom.Compiler.GeneratedCodeAttribute("wsdl", "4.8.3928.0")]
[System.Diagnostics.DebuggerStepThroughAttribute()]
[System.ComponentModel.DesignerCategoryAttribute("code")]
public partial class GetUtcDateTimeTicksCompletedEventArgs : System.ComponentModel.AsyncCompletedEventArgs {
    
    private object[] results;
    
    internal GetUtcDateTimeTicksCompletedEventArgs(object[] results, System.Exception exception, bool cancelled, object userState) : 
            base(exception, cancelled, userState) {
        this.results = results;
    }
    
    /// <remarks/>
    public long Result {
        get {
            this.RaiseExceptionIfNecessary();
            return ((long)(this.results[0]));
        }
    }
}

/// <remarks/>
[System.CodeDom.Compiler.GeneratedCodeAttribute("wsdl", "4.8.3928.0")]
public delegate void GetLocalDiffernceTicksCompletedEventHandler(object sender, GetLocalDiffernceTicksCompletedEventArgs e);

/// <remarks/>
[System.CodeDom.Compiler.GeneratedCodeAttribute("wsdl", "4.8.3928.0")]
[System.Diagnostics.DebuggerStepThroughAttribute()]
[System.ComponentModel.DesignerCategoryAttribute("code")]
public partial class GetLocalDiffernceTicksCompletedEventArgs : System.ComponentModel.AsyncCompletedEventArgs {
    
    private object[] results;
    
    internal GetLocalDiffernceTicksCompletedEventArgs(object[] results, System.Exception exception, bool cancelled, object userState) : 
            base(exception, cancelled, userState) {
        this.results = results;
    }
    
    /// <remarks/>
    public long Result {
        get {
            this.RaiseExceptionIfNecessary();
            return ((long)(this.results[0]));
        }
    }
}

/// <remarks/>
[System.CodeDom.Compiler.GeneratedCodeAttribute("wsdl", "4.8.3928.0")]
public delegate void GetUtcDiffernceTicksCompletedEventHandler(object sender, GetUtcDiffernceTicksCompletedEventArgs e);

/// <remarks/>
[System.CodeDom.Compiler.GeneratedCodeAttribute("wsdl", "4.8.3928.0")]
[System.Diagnostics.DebuggerStepThroughAttribute()]
[System.ComponentModel.DesignerCategoryAttribute("code")]
public partial class GetUtcDiffernceTicksCompletedEventArgs : System.ComponentModel.AsyncCompletedEventArgs {
    
    private object[] results;
    
    internal GetUtcDiffernceTicksCompletedEventArgs(object[] results, System.Exception exception, bool cancelled, object userState) : 
            base(exception, cancelled, userState) {
        this.results = results;
    }
    
    /// <remarks/>
    public long Result {
        get {
            this.RaiseExceptionIfNecessary();
            return ((long)(this.results[0]));
        }
    }
}

/// <remarks/>
[System.CodeDom.Compiler.GeneratedCodeAttribute("wsdl", "4.8.3928.0")]
public delegate void GetLocalDateTimeAndDiffernceTicksCompletedEventHandler(object sender, GetLocalDateTimeAndDiffernceTicksCompletedEventArgs e);

/// <remarks/>
[System.CodeDom.Compiler.GeneratedCodeAttribute("wsdl", "4.8.3928.0")]
[System.Diagnostics.DebuggerStepThroughAttribute()]
[System.ComponentModel.DesignerCategoryAttribute("code")]
public partial class GetLocalDateTimeAndDiffernceTicksCompletedEventArgs : System.ComponentModel.AsyncCompletedEventArgs {
    
    private object[] results;
    
    internal GetLocalDateTimeAndDiffernceTicksCompletedEventArgs(object[] results, System.Exception exception, bool cancelled, object userState) : 
            base(exception, cancelled, userState) {
        this.results = results;
    }
    
    /// <remarks/>
    public System.DateTime Result {
        get {
            this.RaiseExceptionIfNecessary();
            return ((System.DateTime)(this.results[0]));
        }
    }
    
    /// <remarks/>
    public long DiffernceTicks {
        get {
            this.RaiseExceptionIfNecessary();
            return ((long)(this.results[1]));
        }
    }
}

/// <remarks/>
[System.CodeDom.Compiler.GeneratedCodeAttribute("wsdl", "4.8.3928.0")]
public delegate void GetUtcDateTimeAndDiffernceTicksCompletedEventHandler(object sender, GetUtcDateTimeAndDiffernceTicksCompletedEventArgs e);

/// <remarks/>
[System.CodeDom.Compiler.GeneratedCodeAttribute("wsdl", "4.8.3928.0")]
[System.Diagnostics.DebuggerStepThroughAttribute()]
[System.ComponentModel.DesignerCategoryAttribute("code")]
public partial class GetUtcDateTimeAndDiffernceTicksCompletedEventArgs : System.ComponentModel.AsyncCompletedEventArgs {
    
    private object[] results;
    
    internal GetUtcDateTimeAndDiffernceTicksCompletedEventArgs(object[] results, System.Exception exception, bool cancelled, object userState) : 
            base(exception, cancelled, userState) {
        this.results = results;
    }
    
    /// <remarks/>
    public System.DateTime Result {
        get {
            this.RaiseExceptionIfNecessary();
            return ((System.DateTime)(this.results[0]));
        }
    }
    
    /// <remarks/>
    public long DiffernceTicks {
        get {
            this.RaiseExceptionIfNecessary();
            return ((long)(this.results[1]));
        }
    }
}
