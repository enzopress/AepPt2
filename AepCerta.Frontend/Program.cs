using AepCerta.Frontend.Services;
using AepCerta.Frontend;
using Microsoft.AspNetCore.Components.Web;
using Microsoft.AspNetCore.Components.WebAssembly.Hosting;

var builder = WebAssemblyHostBuilder.CreateDefault(args);
builder.RootComponents.Add<App>("#app");
builder.RootComponents.Add<HeadOutlet>("head::after");
builder.Services.AddScoped(sp => new HttpClient
{
    BaseAddress = new Uri("http://localhost:8080/")
});
builder.Services.AddScoped<ApiUriService>();
builder.Services.AddScoped<AuthApiService>();
builder.Services.AddScoped<ProtocolosApiService>();


await builder.Build().RunAsync();
