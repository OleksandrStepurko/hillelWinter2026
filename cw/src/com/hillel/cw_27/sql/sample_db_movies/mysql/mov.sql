-- Вивести всі фільми
select title, budget, popularity, runtime from movie;
select m.title, m.budget, m.popularity, m.runtime from movie m;

-- Вивести назву та дату виходу фільмів
select m.title, m.release_date from movie m ;

-- Знайти всі фільми з рейтингом вище 7
select *  from movie where vote_average > 7;

-- Знайти фільми, що вийшли після 2015 року
select *  from movie where release_date > '2014-12-31';

-- Відсортувати фільми за популярністю (за спаданням)
select *  from movie order by popularity desc; -- asc

-- Знайти фільми з бюджетом більше 100 млн
select *  from movie where budget > 100000000;

-- Знайти фільми без опису
select *  from movie where overview is null;

-- Знайти фільми з тривалістю від 90 до 120 хвилин
select m.runtime , m.*  from movie m where m.runtime between 90 and 120 order by m.runtime asc;

-- Знайти фільми, де назва містить "Love"
select *  from movie where title like '%love%';

-- Знайти фільми, де дохід більший за бюджет
select *  from movie where revenue > budget;

-- Знайти кількість фільми, де назва містить "Love"
select count(*)  from movie where title like '%love%';


-- JOIN block
-- Вивести фільми та їх жанри
select m.title, g.genre_name from movie m
left join movie_genres mg on m.movie_id = mg.movie_id
left join genre g on g.genre_id = mg.genre_id;

-- найти всі фільми жанру "Action"
select m.title, g.genre_name from movie m
left join movie_genres mg on m.movie_id = mg.movie_id
left join genre g on g.genre_id = mg.genre_id
where  g.genre_name = 'ACTION';

-- Вивести фільми та країни виробництва
select m.title, c.country_name, c.country_iso_code from movie m
left join production_country pc on m.movie_id = pc.movie_id
left join country c on c.country_id = pc.country_id;
-- where  g.genre_name = 'ACTION';

-- Знайти фільми, зняті в США
select m.title, c.country_name, c.country_iso_code from movie m
left join production_country pc on m.movie_id = pc.movie_id
left join country c on c.country_id = pc.country_id
where c.country_iso_code = 'US';

-- Вивести фільми та компанії виробництва
select m.movie_id,  m.title, c.company_name from movie m
left join movie_company mc on m.movie_id = mc.movie_id
left join production_company c on c.company_id = mc.company_id;


-- JOIN + фільтрація
-- Знайти фільми, де знімався "Tom Hanks"
select distinct m.title from movie m
left join movie_crew mc on m.movie_id = mc.movie_id
left join person p on p.person_id = mc.person_id
where p.person_name = 'Tom Hanks';

-- Вивести акторів фільму з ID = 10
select p.person_name, character_name from movie_cast mc
join person p on mc.person_id = p.person_id
where mc.movie_id = 285;
-- Знайти фільми, де люди працювали в crew
-- todo
-- Знайти режисерів та їх фільми
-- todo
-- Знайти фільми з більше ніж 3 акторами
select distinct m.title from movie m
left join movie_crew mc on m.movie_id = mc.movie_id
group by m.movie_id, m.title
having count(mc.person_id) < 3;


-- GROUP BY
-- Порахувати кількість фільмів
select count(*) as film_count from movie;
-- Порахувати кількість фільмів у кожному жанрі
select g.genre_name, count(*) as movey_count from genre g
left join movie_genres mg on g.genre_id = mg.genre_id
group by g.genre_id, g.genre_name;
-- Знайти середній рейтинг фільмів
select avg(vote_average) from movie;
-- Знайти максимальний бюджет
select max(budget) from movie;
-- Порахувати кількість фільмів для кожної компанії
select pc.company_name , count(*) as film_count from production_company pc
left join movie_company mc on pc.company_id =mc.company_id
group by pc.company_name, pc.company_id order by film_count desc ;
