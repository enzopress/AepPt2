using System.ComponentModel.DataAnnotations;

namespace AepCerta.Frontend.Models.Auth;

public class RegisterRequest
{
    [Required]
    public string Nome { get; set; } = string.Empty;

    [Required]
    public string Identificador { get; set; } = string.Empty;

    [Required]
    [MinLength(4)]
    public string Senha { get; set; } = string.Empty;
}
