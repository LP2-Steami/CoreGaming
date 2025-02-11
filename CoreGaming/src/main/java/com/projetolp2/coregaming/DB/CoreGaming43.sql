--
-- PostgreSQL database dump
--

-- Dumped from database version 17.0
-- Dumped by pg_dump version 17.0

-- Started on 2025-01-17 23:34:13

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 227 (class 1259 OID 24849)
-- Name: avaliacao; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.avaliacao (
    id_avaliacao integer NOT NULL,
    id_usuario integer NOT NULL,
    id_jogo integer NOT NULL,
    nota integer,
    comentario text,
    data_avaliacao timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT avaliacao_nota_check CHECK (((nota >= 1) AND (nota <= 5)))
);


ALTER TABLE public.avaliacao OWNER TO postgres;

--
-- TOC entry 226 (class 1259 OID 24848)
-- Name: avaliacao_id_avaliacao_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.avaliacao_id_avaliacao_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.avaliacao_id_avaliacao_seq OWNER TO postgres;

--
-- TOC entry 4869 (class 0 OID 0)
-- Dependencies: 226
-- Name: avaliacao_id_avaliacao_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.avaliacao_id_avaliacao_seq OWNED BY public.avaliacao.id_avaliacao;


--
-- TOC entry 228 (class 1259 OID 24869)
-- Name: biblioteca; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.biblioteca (
    id_usuario integer NOT NULL,
    id_jogo integer NOT NULL,
    data_adicionado timestamp without time zone DEFAULT CURRENT_TIMESTAMP
);


ALTER TABLE public.biblioteca OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 24796)
-- Name: desenvolvedor; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.desenvolvedor (
    id_desenvolvedor integer NOT NULL,
    nome character varying(100) NOT NULL,
    website character varying(255),
    email_contato character varying(100)
);


ALTER TABLE public.desenvolvedor OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 24795)
-- Name: desenvolvedor_id_desenvolvedor_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.desenvolvedor_id_desenvolvedor_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.desenvolvedor_id_desenvolvedor_seq OWNER TO postgres;

--
-- TOC entry 4870 (class 0 OID 0)
-- Dependencies: 219
-- Name: desenvolvedor_id_desenvolvedor_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.desenvolvedor_id_desenvolvedor_seq OWNED BY public.desenvolvedor.id_desenvolvedor;


--
-- TOC entry 222 (class 1259 OID 24805)
-- Name: jogo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.jogo (
    id_jogo integer NOT NULL,
    titulo character varying(150) NOT NULL,
    descricao text,
    preco numeric(10,2) NOT NULL,
    data_lancamento date,
    id_desenvolvedor integer NOT NULL,
    foto bytea
);


ALTER TABLE public.jogo OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 24804)
-- Name: jogo_id_jogo_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.jogo_id_jogo_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.jogo_id_jogo_seq OWNER TO postgres;

--
-- TOC entry 4871 (class 0 OID 0)
-- Dependencies: 221
-- Name: jogo_id_jogo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.jogo_id_jogo_seq OWNED BY public.jogo.id_jogo;


--
-- TOC entry 224 (class 1259 OID 24819)
-- Name: transacao; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.transacao (
    id_transacao integer NOT NULL,
    id_usuario integer NOT NULL,
    id_jogo integer NOT NULL,
    data_transacao timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    preco_pago numeric(10,2) NOT NULL
);


ALTER TABLE public.transacao OWNER TO postgres;

--
-- TOC entry 223 (class 1259 OID 24818)
-- Name: transacao_id_transacao_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.transacao_id_transacao_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.transacao_id_transacao_seq OWNER TO postgres;

--
-- TOC entry 4872 (class 0 OID 0)
-- Dependencies: 223
-- Name: transacao_id_transacao_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.transacao_id_transacao_seq OWNED BY public.transacao.id_transacao;


--
-- TOC entry 225 (class 1259 OID 24831)
-- Name: transacao_jogo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.transacao_jogo (
    id_transacao integer NOT NULL,
    id_jogo integer NOT NULL,
    quantidade integer DEFAULT 1,
    preco_unitario numeric(10,2) NOT NULL,
    CONSTRAINT transacao_jogo_quantidade_check CHECK ((quantidade > 0))
);


ALTER TABLE public.transacao_jogo OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 24784)
-- Name: usuario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.usuario (
    id_usuario integer NOT NULL,
    nome character varying(100) NOT NULL,
    email character varying(100) NOT NULL,
    senha character varying(255) NOT NULL,
    data_criacao timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    foto bytea
);


ALTER TABLE public.usuario OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 24783)
-- Name: usuario_id_usuario_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.usuario_id_usuario_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.usuario_id_usuario_seq OWNER TO postgres;

--
-- TOC entry 4873 (class 0 OID 0)
-- Dependencies: 217
-- Name: usuario_id_usuario_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.usuario_id_usuario_seq OWNED BY public.usuario.id_usuario;


--
-- TOC entry 4676 (class 2604 OID 24886)
-- Name: avaliacao id_avaliacao; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.avaliacao ALTER COLUMN id_avaliacao SET DEFAULT nextval('public.avaliacao_id_avaliacao_seq'::regclass);


--
-- TOC entry 4671 (class 2604 OID 24887)
-- Name: desenvolvedor id_desenvolvedor; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.desenvolvedor ALTER COLUMN id_desenvolvedor SET DEFAULT nextval('public.desenvolvedor_id_desenvolvedor_seq'::regclass);


--
-- TOC entry 4672 (class 2604 OID 24888)
-- Name: jogo id_jogo; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.jogo ALTER COLUMN id_jogo SET DEFAULT nextval('public.jogo_id_jogo_seq'::regclass);


--
-- TOC entry 4673 (class 2604 OID 24889)
-- Name: transacao id_transacao; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.transacao ALTER COLUMN id_transacao SET DEFAULT nextval('public.transacao_id_transacao_seq'::regclass);


--
-- TOC entry 4669 (class 2604 OID 24890)
-- Name: usuario id_usuario; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario ALTER COLUMN id_usuario SET DEFAULT nextval('public.usuario_id_usuario_seq'::regclass);


--
-- TOC entry 4862 (class 0 OID 24849)
-- Dependencies: 227
-- Data for Name: avaliacao; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.avaliacao (id_avaliacao, id_usuario, id_jogo, nota, comentario, data_avaliacao) FROM stdin;
\.


--
-- TOC entry 4863 (class 0 OID 24869)
-- Dependencies: 228
-- Data for Name: biblioteca; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.biblioteca (id_usuario, id_jogo, data_adicionado) FROM stdin;
\.


--
-- TOC entry 4855 (class 0 OID 24796)
-- Dependencies: 220
-- Data for Name: desenvolvedor; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.desenvolvedor (id_desenvolvedor, nome, website, email_contato) FROM stdin;
\.


--
-- TOC entry 4857 (class 0 OID 24805)
-- Dependencies: 222
-- Data for Name: jogo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.jogo (id_jogo, titulo, descricao, preco, data_lancamento, id_desenvolvedor, foto) FROM stdin;
\.


--
-- TOC entry 4859 (class 0 OID 24819)
-- Dependencies: 224
-- Data for Name: transacao; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.transacao (id_transacao, id_usuario, id_jogo, data_transacao, preco_pago) FROM stdin;
\.


--
-- TOC entry 4860 (class 0 OID 24831)
-- Dependencies: 225
-- Data for Name: transacao_jogo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.transacao_jogo (id_transacao, id_jogo, quantidade, preco_unitario) FROM stdin;
\.


--
-- TOC entry 4853 (class 0 OID 24784)
-- Dependencies: 218
-- Data for Name: usuario; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.usuario (id_usuario, nome, email, senha, data_criacao, foto) FROM stdin;
\.


--
-- TOC entry 4874 (class 0 OID 0)
-- Dependencies: 226
-- Name: avaliacao_id_avaliacao_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.avaliacao_id_avaliacao_seq', 1, false);


--
-- TOC entry 4875 (class 0 OID 0)
-- Dependencies: 219
-- Name: desenvolvedor_id_desenvolvedor_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.desenvolvedor_id_desenvolvedor_seq', 1, false);


--
-- TOC entry 4876 (class 0 OID 0)
-- Dependencies: 221
-- Name: jogo_id_jogo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.jogo_id_jogo_seq', 1, false);


--
-- TOC entry 4877 (class 0 OID 0)
-- Dependencies: 223
-- Name: transacao_id_transacao_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.transacao_id_transacao_seq', 1, false);


--
-- TOC entry 4878 (class 0 OID 0)
-- Dependencies: 217
-- Name: usuario_id_usuario_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.usuario_id_usuario_seq', 1, false);


--
-- TOC entry 4696 (class 2606 OID 24858)
-- Name: avaliacao avaliacao_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.avaliacao
    ADD CONSTRAINT avaliacao_pkey PRIMARY KEY (id_avaliacao);


--
-- TOC entry 4698 (class 2606 OID 24874)
-- Name: biblioteca biblioteca_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.biblioteca
    ADD CONSTRAINT biblioteca_pkey PRIMARY KEY (id_usuario, id_jogo);


--
-- TOC entry 4686 (class 2606 OID 24803)
-- Name: desenvolvedor desenvolvedor_email_contato_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.desenvolvedor
    ADD CONSTRAINT desenvolvedor_email_contato_key UNIQUE (email_contato);


--
-- TOC entry 4688 (class 2606 OID 24801)
-- Name: desenvolvedor desenvolvedor_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.desenvolvedor
    ADD CONSTRAINT desenvolvedor_pkey PRIMARY KEY (id_desenvolvedor);


--
-- TOC entry 4690 (class 2606 OID 24812)
-- Name: jogo jogo_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.jogo
    ADD CONSTRAINT jogo_pkey PRIMARY KEY (id_jogo);


--
-- TOC entry 4694 (class 2606 OID 24837)
-- Name: transacao_jogo transacao_jogo_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.transacao_jogo
    ADD CONSTRAINT transacao_jogo_pkey PRIMARY KEY (id_transacao, id_jogo);


--
-- TOC entry 4692 (class 2606 OID 24825)
-- Name: transacao transacao_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.transacao
    ADD CONSTRAINT transacao_pkey PRIMARY KEY (id_transacao);


--
-- TOC entry 4682 (class 2606 OID 24794)
-- Name: usuario usuario_email_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_email_key UNIQUE (email);


--
-- TOC entry 4684 (class 2606 OID 24792)
-- Name: usuario usuario_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (id_usuario);


--
-- TOC entry 4703 (class 2606 OID 24864)
-- Name: avaliacao avaliacao_id_jogo_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.avaliacao
    ADD CONSTRAINT avaliacao_id_jogo_fkey FOREIGN KEY (id_jogo) REFERENCES public.jogo(id_jogo);


--
-- TOC entry 4704 (class 2606 OID 24859)
-- Name: avaliacao avaliacao_id_usuario_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.avaliacao
    ADD CONSTRAINT avaliacao_id_usuario_fkey FOREIGN KEY (id_usuario) REFERENCES public.usuario(id_usuario);


--
-- TOC entry 4705 (class 2606 OID 24880)
-- Name: biblioteca biblioteca_id_jogo_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.biblioteca
    ADD CONSTRAINT biblioteca_id_jogo_fkey FOREIGN KEY (id_jogo) REFERENCES public.jogo(id_jogo);


--
-- TOC entry 4706 (class 2606 OID 24875)
-- Name: biblioteca biblioteca_id_usuario_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.biblioteca
    ADD CONSTRAINT biblioteca_id_usuario_fkey FOREIGN KEY (id_usuario) REFERENCES public.usuario(id_usuario);


--
-- TOC entry 4699 (class 2606 OID 24813)
-- Name: jogo jogo_id_desenvolvedor_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.jogo
    ADD CONSTRAINT jogo_id_desenvolvedor_fkey FOREIGN KEY (id_desenvolvedor) REFERENCES public.desenvolvedor(id_desenvolvedor);


--
-- TOC entry 4700 (class 2606 OID 24826)
-- Name: transacao transacao_id_usuario_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.transacao
    ADD CONSTRAINT transacao_id_usuario_fkey FOREIGN KEY (id_usuario) REFERENCES public.usuario(id_usuario);


--
-- TOC entry 4701 (class 2606 OID 24843)
-- Name: transacao_jogo transacao_jogo_id_jogo_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.transacao_jogo
    ADD CONSTRAINT transacao_jogo_id_jogo_fkey FOREIGN KEY (id_jogo) REFERENCES public.jogo(id_jogo);


--
-- TOC entry 4702 (class 2606 OID 24838)
-- Name: transacao_jogo transacao_jogo_id_transacao_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.transacao_jogo
    ADD CONSTRAINT transacao_jogo_id_transacao_fkey FOREIGN KEY (id_transacao) REFERENCES public.transacao(id_transacao);


-- Completed on 2025-01-17 23:34:14

--
-- PostgreSQL database dump complete
--

