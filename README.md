# sistema-distribuido
Tarefa da matéria de sistemas distribuidos
Tarefa proposta na matéria de sistemas distribuidos do curso de Sistemas de Informação - FACCAT
A tarefa proposta era implementar um sistema distruibuido com balanceamento de carga e banco de dados distribuido.
Todo projeto foi implementado utilizando containers docker.
Foram configuradas 3 aplicações java com spring boot para rodar nas portas 8080, 8081 e 8082 cada uma em um container, outro container para rodar um servidor nginx para funcionar como proxy reverso e balancceador de carga, um container para o gerenciador
de clusters mysql, 2 containers para os clusters sql e um container para o servidor centralizador mysql.
