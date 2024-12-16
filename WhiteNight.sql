CREATE TABLE wn_users (
    user_id VARCHAR(50) PRIMARY KEY,    -- 사용자 ID (직접 입력, 고유 값)
    email VARCHAR(255) UNIQUE NOT NULL, -- 이메일 (고유 값)
    password VARCHAR(255) NOT NULL,     -- 비밀번호
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP -- 생성 시간
);


CREATE TABLE wn_quotes (
    quote_id VARCHAR(50) PRIMARY KEY,   -- 문구 ID (직접 입력, 고유 값)
    text VARCHAR(255) NOT NULL,         -- 동기부여 문구
    category VARCHAR(50) NOT NULL       -- 카테고리 (예: 용기, 행복)
);

CREATE TABLE wn_favorites (
    favorite_id VARCHAR(50) PRIMARY KEY, -- 즐겨찾기 고유 ID (직접 입력 또는 UUID)
    user_id VARCHAR(50) NOT NULL,        -- 사용자 ID
    quote_id VARCHAR(50) NOT NULL,       -- 문구 ID
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP -- 생성 시간
);

CREATE TABLE wn_tasks (
    task_id VARCHAR(50) PRIMARY KEY,    -- 체크리스트 ID (고유 값)
    user_id VARCHAR(50) NOT NULL,       -- 사용자 ID
    quote_id VARCHAR(50) NOT NULL,      -- 문구 ID (즐겨찾기와 연관된 문구)
    task_text VARCHAR(255) NOT NULL,   -- 체크리스트 내용
    completed BOOLEAN DEFAULT FALSE,   -- 완료 여부
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP -- 생성 시간
);
