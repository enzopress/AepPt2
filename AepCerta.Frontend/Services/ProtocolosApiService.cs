using AepCerta.Frontend.Models.Protocolos;
using System.Net.Http.Json;
using System.Text.Json;
using System.Text.Json.Serialization;

namespace AepCerta.Frontend.Services;

public class ProtocolosApiService(HttpClient httpClient, ApiUriService apiUriService)
{
    private static readonly JsonSerializerOptions JsonOptions = new(JsonSerializerDefaults.Web)
    {
        Converters = { new JsonStringEnumConverter() }
    };

    public async Task<List<ProtocoloDto>> ListarAsync()
    {
        var response = await httpClient.GetAsync(apiUriService.Protocolos());
        response.EnsureSuccessStatusCode();

        return await response.Content.ReadFromJsonAsync<List<ProtocoloDto>>(JsonOptions)
               ?? new List<ProtocoloDto>();
    }

    public async Task<ProtocoloDto?> ObterAsync(int numeroProtocolo)
    {
        var url = apiUriService.ProtocoloById(numeroProtocolo);

        Console.WriteLine(url);

        var response = await httpClient.GetAsync(apiUriService.ProtocoloById(numeroProtocolo));
        if (!response.IsSuccessStatusCode)
        {
            return null;
        }

        return await response.Content.ReadFromJsonAsync<ProtocoloDto>(JsonOptions);
    }

    public async Task<ProtocoloDto?> CriarAsync(ProtocoloDto protocolo)
    {
        Console.WriteLine(
    JsonSerializer.Serialize(
        protocolo,
        new JsonSerializerOptions
        {
            WriteIndented = true
        }));
        var response = await httpClient.PostAsJsonAsync(apiUriService.Protocolos(), protocolo);
        return await response.Content.ReadFromJsonAsync<ProtocoloDto>(JsonOptions);
    }

    public async Task<ProtocoloDto?> AtualizarAsync(ProtocoloDto protocolo)
    {
        var response = await httpClient.PutAsJsonAsync(apiUriService.ProtocoloById(protocolo.NumeroProtocolo), protocolo);
        return await response.Content.ReadFromJsonAsync<ProtocoloDto>(JsonOptions);
    }

    public async Task ExcluirAsync(int? numeroProtocolo)
    {
        await httpClient.DeleteAsync(apiUriService.ProtocoloById(numeroProtocolo));
    }
}
