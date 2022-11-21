function Tabela({vetor, selecionar}) {
    return <div>
        <table className="table">
            <thead>
                <tr>
                    <th>#</th>
                    <th>Nome</th>
                    <th>Marca</th>
                    <th>Selecionar</th>
                </tr>
            </thead>

            <tbody>
                {
                    vetor.map((obj, indice) => (
                        <tr key={indice}>
                            <td>{indice + 1}</td>
                            <td>{obj.nome}</td>
                            <td>{obj.marca}</td>
                            <td><btn onClick={() => {selecionar(indice)}} className="btn btn-success">Selecionar</btn></td>
                        </tr>
                    ))
                }
            </tbody>
        </table>
    </div>
}

export default Tabela;