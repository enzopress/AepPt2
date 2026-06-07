namespace AepCerta.Frontend.Models.Auth;

public class AuthResponse
{
    public bool Sucesso { get; set; }
    public string Mensagem { get; set; } = string.Empty;
    public string? Nome { get; set; }
    public string? Perfil { get; set; }
    public string? Identificador { get; set; }
}
