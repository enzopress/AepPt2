namespace AepCerta.Frontend.Services;

public class ApiUriService
{
    private const string UsuariosBase = "usuarios";
   

    public string LoginCidadao() =>
    $"{UsuariosBase}/login-cidadao";

    public string LoginFuncionario() =>
        $"{UsuariosBase}/login-funcionario";

    // ==========================
    // USUÁRIOS
    // ==========================

    public string Usuarios() =>
        UsuariosBase;

    public string UsuarioById(int id) =>
        $"{UsuariosBase}/{id}";

    // ==========================
    // CIDADÃOS
    // ==========================

    public string Cidadaos() =>
        $"{UsuariosBase}/cidadaos";

    public string CidadaoById(int id) =>
        $"{UsuariosBase}/cidadaos/{id}";

    // ==========================
    // FUNCIONÁRIOS
    // ==========================

    public string Funcionarios() =>
        $"{UsuariosBase}/funcionarios";

    public string FuncionarioById(int id) =>
        $"{UsuariosBase}/funcionarios/{id}";

    // ==========================
    // PROTOCOLOS
    // ==========================

    public string Protocolos() =>
        $"/protocolos";

    public string ProtocoloById(int? numeroProtocolo) =>
        $"/protocolos/{numeroProtocolo}";
}