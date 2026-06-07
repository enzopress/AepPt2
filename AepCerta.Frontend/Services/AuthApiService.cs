using AepCerta.Frontend.Models.Auth;
using System.Net.Http.Json;
using System.Text.Json;

namespace AepCerta.Frontend.Services;

public class AuthApiService(HttpClient httpClient, ApiUriService apiUriService)
{



    public Task<AuthResponse> RegistrarCidadaoAsync(RegisterRequest request)
        => PostAuthAsync(apiUriService.Cidadaos(), request, "cadastro de cidadão");

    public async Task<AuthResponse> LoginCidadaoAsync(LoginRequest request)
    {
        var payload = new
        {
            cpf = request.Identificador,
            senha = request.Senha
        };

        var response = await httpClient.PostAsJsonAsync(
            apiUriService.LoginCidadao(),
            payload);
        if (!response.IsSuccessStatusCode)
        {
            return new AuthResponse
            {
                Sucesso = false,
                Mensagem = "CPF ou senha inválidos."
            };
        }

        return await response.Content.ReadFromJsonAsync<AuthResponse>()
               ?? new AuthResponse();
    }
    public Task<AuthResponse> RegistrarFuncionarioAsync(RegisterRequest request)
    {
        Console.WriteLine(
    JsonSerializer.Serialize(request,
        new JsonSerializerOptions
        {
            WriteIndented = true
        }));
        return  PostAuthAsync(apiUriService.Funcionarios(), request, "cadastro de funcionário");
            }

    public async Task<AuthResponse> LoginFuncionarioAsync(LoginRequest request)
    {
        var payload = new
        {
            matricula = request.Identificador,
            senha = request.Senha
        };

        var response = await httpClient.PostAsJsonAsync(
            apiUriService.LoginFuncionario(),
            payload);

        if (!response.IsSuccessStatusCode)
        {
            return new AuthResponse
            {
                Sucesso = false,
                Mensagem = "Matrícula ou senha inválidos."
            };
        }

        return await response.Content.ReadFromJsonAsync<AuthResponse>()
               ?? new AuthResponse
               {
                   Sucesso = false,
                   Mensagem = "Resposta inválida do servidor."
               };
    }

    private async Task<AuthResponse> PostAuthAsync<TRequest>(string uri, TRequest request, string operacao)
    {
        var response = await httpClient.PostAsJsonAsync(uri, request);
        var payload = await response.Content.ReadFromJsonAsync<AuthResponse>();

        return payload ?? new AuthResponse
        {
            Sucesso = false,
            Mensagem = $"Nao foi possivel processar a resposta de {operacao}."
        };
    }
}
