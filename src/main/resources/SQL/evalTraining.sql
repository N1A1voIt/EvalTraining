--
-- PostgreSQL database dump
--

-- Dumped from database version 14.10
-- Dumped by pg_dump version 14.10

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
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
-- Name: personne; Type: TABLE; Schema: public; Owner: testeval
--

CREATE TABLE public.personne (
    id bigint NOT NULL,
    name character varying(250) NOT NULL,
    age integer NOT NULL
);


ALTER TABLE public.personne OWNER TO testeval;

--
-- Name: personne_id_seq; Type: SEQUENCE; Schema: public; Owner: testeval
--

CREATE SEQUENCE public.personne_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.personne_id_seq OWNER TO testeval;

--
-- Name: personne_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: testeval
--

ALTER SEQUENCE public.personne_id_seq OWNED BY public.personne.id;


--
-- Name: users; Type: TABLE; Schema: public; Owner: testeval
--

CREATE TABLE public.users (
    id bigint NOT NULL,
    firstname character varying(250) NOT NULL,
    username character varying(250) NOT NULL,
    mail character varying(250) NOT NULL,
    password character varying(250) NOT NULL
);


ALTER TABLE public.users OWNER TO testeval;

--
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: testeval
--

CREATE SEQUENCE public.users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.users_id_seq OWNER TO testeval;

--
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: testeval
--

ALTER SEQUENCE public.users_id_seq OWNED BY public.users.id;


--
-- Name: personne id; Type: DEFAULT; Schema: public; Owner: testeval
--

ALTER TABLE ONLY public.personne ALTER COLUMN id SET DEFAULT nextval('public.personne_id_seq'::regclass);


--
-- Name: users id; Type: DEFAULT; Schema: public; Owner: testeval
--

ALTER TABLE ONLY public.users ALTER COLUMN id SET DEFAULT nextval('public.users_id_seq'::regclass);


--
-- Data for Name: personne; Type: TABLE DATA; Schema: public; Owner: testeval
--

COPY public.personne (id, name, age) FROM stdin;
1	Jean	12
2	Bera	13
\.


--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: testeval
--

COPY public.users (id, firstname, username, mail, password) FROM stdin;
\.


--
-- Name: personne_id_seq; Type: SEQUENCE SET; Schema: public; Owner: testeval
--

SELECT pg_catalog.setval('public.personne_id_seq', 2, true);


--
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: testeval
--

SELECT pg_catalog.setval('public.users_id_seq', 1, false);


--
-- Name: personne personne_pkey; Type: CONSTRAINT; Schema: public; Owner: testeval
--

ALTER TABLE ONLY public.personne
    ADD CONSTRAINT personne_pkey PRIMARY KEY (id);


--
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: testeval
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

