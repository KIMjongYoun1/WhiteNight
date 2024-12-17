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

SELECT * FROM wn_users wu ;
SELECT * FROM wn_favorites wf ;
SELECT * FROM wn_tasks wt ;

-- 샘플데이터 

INSERT INTO wn_quotes (quote_id, text, category) VALUES 
(UUID(), '당신의 한계는 당신이 만드는 것이다.', '용기'),
(UUID(), '작은 일에도 최선을 다하라. 그것이 성공의 열쇠이다.', '성공'),
(UUID(), '성공은 준비된 자에게 찾아온다.', '성공'),
(UUID(), '꿈을 이루는 비결은 시작하는 것이다.', '도전'),
(UUID(), '행복은 당신의 선택이다.', '행복'),
(UUID(), '실패는 성공으로 가는 과정일 뿐이다.', '용기');

-- 테이블수정
ALTER TABLE wn_users
MODIFY COLUMN created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP;

ALTER TABLE wn_favorites ADD COLUMN quote_text VARCHAR(255) NOT NULL;


-- 쿼리 테스티


SELECT 
    f.favorite_id, f.user_id, f.quote_id, 
    q.text AS quote_text, 
    t.task_id, t.task_text, t.completed, t.created_at
FROM wn_favorites f
LEFT JOIN wn_quotes q ON f.quote_id = q.quote_id
LEFT JOIN wn_tasks t ON f.user_id = t.user_id AND f.quote_id = t.quote_id
WHERE f.user_id = '테스트 유저 ID';

