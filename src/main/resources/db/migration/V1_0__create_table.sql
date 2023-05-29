CREATE TABLE IF NOT EXISTS public.case_(
	caseid BIGINT NOT NULL,
	creation_date TIMESTAMP,
	last_update_date TIMESTAMP,
	title VARCHAR(255),
	description VARCHAR(2056),
	PRIMARY KEY(caseId)
);
CREATE SEQUENCE IF NOT EXISTS public.case_seq START WITH 1 INCREMENT BY 1;