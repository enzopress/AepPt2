namespace AepCerta.Frontend.Models.Protocolos;

public class ProtocoloDto
{
    public int? NumeroProtocolo { get; set; }
    public int Tipo { get; set; }
    public string Descricao { get; set; } = string.Empty;
    public string Cep { get; set; } = string.Empty;
    public string Rua { get; set; } = string.Empty;
    public int Numero { get; set; }
    public string Bairro { get; set; } = string.Empty;
    public string Complemento { get; set; } = string.Empty;
    public string CpfSolicitante { get; set; } = string.Empty;
    public StatusProtocolo Status { get; set; } = StatusProtocolo.Aberto;
}
