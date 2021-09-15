-- 프로그래머스 코딩테스트 연습 > JOIN

-- https://programmers.co.kr/learn/courses/30/lessons/59042
SELECT ao.animal_id, ao.name
from ANIMAL_OUTS AO
         LEFT JOIN ANIMAL_INS AI ON ao.animal_id = ai.animal_id
WHERE ai.animal_id IS NULL

-- https://programmers.co.kr/learn/courses/30/lessons/59043
SELECT ai.ANIMAL_ID, ai.name
from ANIMAL_INS ai
         join ANIMAL_OUTS ao on ai.ANIMAL_ID = ao.ANIMAL_ID
where ao.DATETIME < ai.DATETIME
order by ai.datetime

-- https://programmers.co.kr/learn/courses/30/lessons/59044
SELECT ai.name, ai.datetime
from animal_ins as ai
         left join animal_outs ao on ai.animal_id = ao.animal_id
where ao.animal_id is null
order by ai.datetime asc limit 3;

-- https://programmers.co.kr/learn/courses/30/lessons/59045
SELECT ai.ANIMAL_ID, ai.animal_type, ai.name
from ANIMAL_INS ai
         join ANIMAL_OUTS ao on ai.animal_id = ao.animal_id
where ai.SEX_UPON_INTAKE like "Intact%"
  and (ao.SEX_UPON_OUTCOME like 'Spayed%' or ao.SEX_UPON_OUTCOME like 'Neutered%')
order by ai.animal_id asc;
