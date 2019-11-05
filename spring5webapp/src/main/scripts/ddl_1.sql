USE [TestDB]
GO

CREATE TABLE [dbo].[author](
	[id] [bigint] IDENTITY(1,1) PRIMARY KEY,
	[first_name] [varchar](max) NULL,
	[last_name] [varchar](max) NULL
	)

CREATE TABLE [dbo].[book](
	[id] [bigint] IDENTITY(1,1) PRIMARY KEY,
	[isbn] [varchar](255) NULL,
	[title] [varchar](255) NULL,
	[publisher_id] [bigint] NULL
	)

CREATE TABLE [dbo].[publisher](
	[id] [bigint] IDENTITY(1,1) PRIMARY KEY,
	[address] [varchar](255) NULL,
	[name] [varchar](255) NULL
	)


ALTER TABLE [dbo].[book] ADD  CONSTRAINT [FK_book_publisher_publisher_id] FOREIGN KEY([publisher_id])
REFERENCES [dbo].[publisher] ([id])
GO

CREATE TABLE [dbo].[author_book](
	[book_id] [bigint] NOT NULL,
	[author_id] [bigint] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[book_id] ASC,
	[author_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[author_book] ADD  CONSTRAINT [FK_author_book_author_id] FOREIGN KEY([author_id])
REFERENCES [dbo].[author] ([id])
GO

ALTER TABLE [dbo].[author_book] ADD  CONSTRAINT [FK_author_book_book_id] FOREIGN KEY([book_id])
REFERENCES [dbo].[book] ([id])
GO