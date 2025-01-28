(ns gerenciadorDeDataShow.crud)

 
; Uaná
; criar (id) -> cria um novo datashow com horario "indefinido"
; Vou assumir que tem um agente para a lista chamado ListaDeDatashows
(defn criar [id]
  (send-off ListaDeDatashows (conj ListaDeDatashows {:id id :horario "indefinido"})))

; Alvaro
; alocar (id, horario) -> aloca datashow(id) a um horario

; Malu
; desalocar (id) -> desaloca datashow(id)

; Malu
; realocar (id, horario) -> realoca datashow(id) para um novo horario

; Laura
; deletar (id) -> deleta datashow(id)

; Uaná
; listar () -> lista todos os datashows
(defn listar []
  (await ListaDeDatashows)
  (@ListaDeDatashows))


