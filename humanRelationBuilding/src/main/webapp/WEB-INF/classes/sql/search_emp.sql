select
    *
from
    emp e
where
    lastname_kanji like /*searchWord*/
    or firstname_kanji like /*searchWord*/
    or lastname_katakana like /*searchWord*/
    or firstname_katakana like /*searchWord*/
    or birth_year like /*searchWord*/
    or birth_month like /*searchWord*/
    or birth_day like /*searchWord*/
    or cellphone_num like /*searchWord*/
    or memo like /*searchWord*/