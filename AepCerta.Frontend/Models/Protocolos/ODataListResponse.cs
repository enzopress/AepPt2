namespace AepCerta.Frontend.Models.Protocolos;

public class ODataListResponse<T>
{
    public List<T> Value { get; set; } = new();
}
