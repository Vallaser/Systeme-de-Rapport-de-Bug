/*export interface Post {
  id: number;
  userId: number;
  title: string;
  body: string;
}
*/

export interface Comment {
  comment: string;
  dateComment: string;
  id_bug: string;
  id_comment: BigInteger;
  id_developer: BigInteger;
}
