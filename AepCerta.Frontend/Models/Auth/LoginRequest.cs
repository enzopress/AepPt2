using System.ComponentModel.DataAnnotations;

namespace AepCerta.Frontend.Models.Auth;

public class LoginRequest
{
    [Required]
    public string Identificador { get; set; } = string.Empty;

    [Required]
    [MinLength(4)]
    public string Senha { get; set; } = string.Empty;
}
