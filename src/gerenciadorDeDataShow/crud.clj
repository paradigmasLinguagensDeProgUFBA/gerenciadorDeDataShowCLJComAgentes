(ns gerenciadorDeDataShow.crud
  (:require [gerenciadorDeDataShow.datashow :as datashow]))

 
; Uaná
; criar (id) -> cria um novo datashow com horario "indefinido"
; Vou assumir que tem um agente para a lista chamado ListaDeDatashows
(defn criar [id] 
  (let [ds (datashow/puxar-datashow id)]
    (if (ds == nil)
      (let [ds (datashow/datashow. id "indefinido")]
        (send-off datashow/ListaDeDatashows (datashow/adicionar-datashow ds)))
      (println "Datashow já existe"))))

; Alvaro
; alocar (id, horario) -> aloca datashow(id) a um horario

; Malu
; desalocar (id) -> desaloca datashow(id)

; Malu
; realocar (id, horario) -> realoca datashow(id) para um novo horario

; Laura
; deletar (id) -> deleta datashow(id)
(defn deletar [id]
  (send-off datashow/ListaDeDatashows (datashow/remover-datashow id))) 
; Uaná
; listar () -> lista todos os datashows
(defn listar []
  (await datashow/ListaDeDatashows)
  (deref datashow/ListaDeDatashows))
